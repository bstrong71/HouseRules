package com.example.HouseRules.service;

import com.example.HouseRules.model.Game;
import com.example.HouseRules.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

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

}
