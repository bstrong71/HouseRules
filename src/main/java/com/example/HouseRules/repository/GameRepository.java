package com.example.HouseRules.repository;

import com.example.HouseRules.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findByTitle(String title);
    List<Game> findByCategory(String category);
}
