package com.example.HouseRules.controller;

import com.example.HouseRules.model.Game;
import com.example.HouseRules.repository.GameRepository;
import com.example.HouseRules.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;
//    GameRepository games;

    // convert JSON to Java
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Add Game
     */
    @PostMapping(path = "/api/game/new")
    public String addGame(@RequestBody String json) throws IOException {
        Game game = objectMapper.readValue(json, Game.class);
        gameService.add(game);
        return "Ok";
    }


    @GetMapping(path = "/api/game/{id}")
    public Game findOneGame(@PathVariable("id") int id) {
        Game game = games.findOne(id);
        System.out.println(game);
        return game;
    }

    @GetMapping(path = "/api/games")
    public List<Game> findAllGames() {
        List<Game> gameList = new ArrayList<>();
        games.findAll().forEach(game -> gameList.add(game));
        System.out.println("Successful get to endpoint");
        return gameList;
    }

//    @PutMapping(path = "/api/game/{id}")
//    public Game updateGame(@PathVariable("id") int id, @RequestBody Game game) {
//        Game game = games.findOne(id);
//        System.out.println(game);
//
//        return game;
//    }

    @DeleteMapping(path = "/api/game/{id}/delete")
    public Game deleteGame(@PathVariable("id") int id) {
        Game game = games.findOne(id);
        games.delete(game);
        return game;
    }

    /**
     * Exception handler for GameController. Returns 500 error with exception message
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAppException(Exception ex) {
        System.out.println("\n\n### " + ex);
        ex.printStackTrace();
        return ex.getMessage();
    }
}
