package com.example.HouseRules.service;

import com.example.HouseRules.model.User;
import java.util.List;

public interface UserService {
    User add(User user);
    void add(List<User> allUsers);
    User getById(int id);
    List<User> getAll();
    void update(User user);
    String delete(int id);

}
