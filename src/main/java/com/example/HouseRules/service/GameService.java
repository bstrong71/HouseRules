package com.example.HouseRules.service;

import com.example.HouseRules.model.Alternate;
import com.example.HouseRules.model.Game;

import java.util.List;

public interface GameService {

    Game add(Game game);
    void add(List<Game> allGames);
    Game getById(int id);
    List<Game> getAll();
    void update(Game game);
    void delete(int id);


    Game addAlternate(Alternate alternate);
    Game deleteAlternate(int gameId, int alternateId);

}

