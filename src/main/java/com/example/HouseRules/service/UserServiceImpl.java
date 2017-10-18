package com.example.HouseRules.service;

import com.example.HouseRules.repository.UserRepository;
import com.example.HouseRules.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void add(List<User> users) {
        for (User user : users) {
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public User getById(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public String delete(int id) {
        userRepository.delete(id);
        return "Deleted user " + id + " successfully";
    }

}
