package com.example.HouseRules.controller;

import com.example.HouseRules.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;



@RestController
public class GameController {


    @Autowired
    private GameService gameService;

    /**
     * Convert JSON to Java
     */
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Add Game
     */
    @PostMapping(path = "/api/game/new")
    public String addGame(@RequestBody String json) throws IOException {
        Game game = objectMapper.readValue(json, Game.class);
        gameService.add(game);
        return "New game has been added";
    }


    /**
     * Update Game
     */
    @PutMapping(path = "/api/game/{id}")
    public String updateGame(@PathVariable("id") Integer id, @RequestBody String json) throws IOException {
        Game game = objectMapper.readValue(json, Game.class);
        game.setId(id);
        gameService.update(game);
        return "Game " + id + " has been updated";
    }

    /**
     * Get One Game
     */
    @GetMapping(path = "/api/game/{id}")
    public Game getOneGame(@PathVariable("id") Integer id) {
        return gameService.getById(id);
    }

    /**
     * Get All Games
     */
    @GetMapping(path = "/api/games")
    public List<Game> getAllGames() {
        return gameService.getAll();
    }

    /**
     * Delete Game
     */
    @DeleteMapping(path = "/api/game/{id}/delete")
    public String deleteGame(@PathVariable("id") Integer id) {
        gameService.delete(id);
        return "Deleted game " + id + " successfully";
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
