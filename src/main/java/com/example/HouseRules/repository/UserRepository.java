package com.example.HouseRules.repository;

import com.example.HouseRules.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Integer> {
    public User getByUsername(String username);
    public User getByPassword(String password);



}
