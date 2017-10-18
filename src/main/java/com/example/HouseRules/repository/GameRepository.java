package com.example.HouseRules.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.HouseRules.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {

}
