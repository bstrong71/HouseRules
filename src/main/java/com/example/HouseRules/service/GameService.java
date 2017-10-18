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

    String delete(int id);

<<<<<<< HEAD
}
=======
    Game addAlternate(Alternate alternate);
}
>>>>>>> 0c6e7e6e332bb05bcf4741faa031a14495a6f7a4
