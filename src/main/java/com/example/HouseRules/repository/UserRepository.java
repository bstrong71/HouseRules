package com.example.HouseRules.repository;

import com.example.HouseRules.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
