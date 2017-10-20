package com.example.HouseRules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HouseRules.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
