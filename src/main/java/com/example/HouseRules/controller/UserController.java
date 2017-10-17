package com.example.HouseRules.controller;

import com.example.HouseRules.service.UserService;
import com.example.HouseRules.model.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService  userService;


    private ObjectMapper UserobjectMapper = new ObjectMapper();


    @PostMapping(path = "/api/user/new")
    public String addUser(@RequestBody String json) throws IOException {
        User user = UserobjectMapper.readValue(json, User.class);
        userService.add(user);
        return "HIT";
    }
    @GetMapping (path = "/TEST")
    public String test(){
        return "TESTING";
    }


    @PutMapping(path = "/api/user/{id}")
    public String updateGame(@PathVariable("id") Integer id, @RequestBody String json) throws IOException {
        User user = UserobjectMapper.readValue(json, User.class);
        user.setId(id);
        userService.update(user);
        return "Ok";
    }


    @GetMapping(path = "/api/user/{id}")
    public User getOneUser(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }


    @GetMapping(path = "/api/userList")
    public List<User> getAllUsers() {
        return userService.getAll();
    }


    @DeleteMapping(path = "/api/user/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "Deleted " + id ;
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAppException(Exception ex) {
        System.out.println("\n\n### " + ex);
        ex.printStackTrace();
        return ex.getMessage();
    }
}
