package com.example.HouseRules.controller;

import com.example.HouseRules.service.UserService;
import com.example.HouseRules.model.User;
import com.example.HouseRules.model.LoginRequest;
import com.example.HouseRules.model.SessionManager;
import com.example.HouseRules.repository.UserRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;


@RestController
public class UserController {
    public class SessionInfo {
        public String user;
        public int sessionId;
        public SessionInfo() {

        }
        public void setUserId(String user) {
            this.user =  user;
        }
        public void setSessionId(int sessionId) {
            this.sessionId = sessionId;
        }
    }
    @Autowired
    private UserService  userService;

    @Autowired
    UserRepository userRepository;
    //SessionManager sessionManager;

    //SessionManager sessionManager = new SessionManager();


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

    @PostMapping ("/login")
    SessionInfo login(@RequestBody LoginRequest request) throws IOException {
       // LoginRequest  login = UserobjectMapper.readValue(request, LoginRequest.class);
        String userPassword = request.getPassword();
        String userName = request.getUsername();
        User userNameauth = userRepository.getByUsername(userName);
        User userPasswordauth = userRepository.getByPassword(userPassword);



        if(userNameauth!=null&&userPasswordauth!=null){

            Integer nId = userNameauth.getId();
            Integer pId = userPasswordauth.getId();
            if(nId==pId) {
                System.out.println("ID FOR NAME"+ nId);
                System.out.println("ID FOR PASSWORD"+ pId);
                Integer sessionId = SessionManager.global.createSession(nId);
                System.out.println(sessionId);
                SessionManager.SessionInfo session = SessionManager.global.getValidSession(sessionId);
                User user = userService.getById(session.userId);
                System.out.println("USER: "+ user.getName());
                SessionInfo info = new SessionInfo();
                info.setSessionId(sessionId) ;
                info.setUserId(user.getName());

                return info;
            }else{
                return null;
            }



        }else {
            return null;



        }
    }

    @RequestMapping("/loggedout")
    String logout(Model model) {


        return "Home-Page";
    }

    @GetMapping("/admins-only")
    String admins() {
        return "administration";
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAppException(Exception ex) {
        System.out.println("\n\n### " + ex);
        ex.printStackTrace();
        return ex.getMessage();
    }
}
