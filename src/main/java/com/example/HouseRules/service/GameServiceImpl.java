package com.example.HouseRules.service;

<<<<<<< HEAD
=======
import com.example.HouseRules.model.Alternate;
import com.example.HouseRules.model.Game;
import com.example.HouseRules.repository.AlternateRepository;
>>>>>>> 0c6e7e6e332bb05bcf4741faa031a14495a6f7a4
import com.example.HouseRules.repository.GameRepository;
import com.example.HouseRules.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    AlternateRepository alternateRepository;

    @Transactional
    @Override
    public Game add(Game game) {
        return gameRepository.save(game);
    }

    @Transactional
    @Override
    public void add(List<Game> games) {
        for (Game game : games) {
            gameRepository.save(game);
        }
    }

    @Transactional
    @Override
    public Game getById(int id) {
        return gameRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Game> getAll() {
        List<Game> games = new ArrayList<Game>();
        for (Game game : gameRepository.findAll()) {
            games.add(game);
        }
        return games;
    }

    @Transactional
    @Override
    public void update(Game game) {
        gameRepository.save(game);
    }

    @Transactional
    @Override
    public String delete(int id) {
        gameRepository.delete(id);
        return "Deleted game " + id + " successfully";
    }

    @Transactional
    @Override
    public Game addAlternate(Alternate alternate) {
        alternateRepository.save(alternate);
        Game game = gameRepository.findOne(alternate.getGame().getId());
        game.getAlternates().add(alternate);
        gameRepository.save(game);
        return game;
    }
}
