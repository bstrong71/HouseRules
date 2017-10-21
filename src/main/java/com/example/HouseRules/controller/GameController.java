package com.example.HouseRules.controller;

import com.example.HouseRules.model.Alternate;
import com.example.HouseRules.model.Game;
import com.example.HouseRules.service.AlternateService;
import com.example.HouseRules.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "https://house-rules-jgwrbs.herokuapp.com")
@RestController
public class GameController {


    @Autowired
    private GameService gameService;

    @Autowired
    private AlternateService alternateService;

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

    public List<Game> getAllGames(HttpSession session) {
        System.out.println("session: " + session);
        System.out.println("ACTIVATED");
        return gameService.getAll();
    }

    /**
     * Delete Game
     */
    @DeleteMapping(path = "/api/game/{id}/delete")
    public void deleteGame(@PathVariable("id") Integer id) {
        gameService.delete(id);
//        return "Deleted game " + id + " successfully";
    }

    /**
     * Add Alternate Rule
     */
    @PostMapping(path = "/api/game/{id}/alternate")
    public String addAlternate(@PathVariable("id") Integer id, @RequestBody String json) throws IOException {
        Alternate alternate = objectMapper.readValue(json, Alternate.class);
        Game game = gameService.getById(id);
        alternate.setGame(game);
        gameService.addAlternate(alternate);
        return "Alternate game added";
    }

    /**
     * Update Alternate Rule
     */
    @PutMapping(path = "/api/game/{id}/alternate/{alternateId}")
    public String updateAlternate(@PathVariable("id") Integer id,
                                  @PathVariable("alternateId") Integer alternateId, @RequestBody String json) throws IOException {
        Alternate alternate = objectMapper.readValue(json, Alternate.class);
        alternate.setId(alternateId);
        alternateService.update(alternate);
        return "Alternate rules " + alternateId + " has been updated";
    }

    /**
     * Delete Alternate Rule
     */
    @DeleteMapping(path = "/api/game/{id}/alternate/{alternateId}/delete")
    public void deleteAlternate(@PathVariable("id") Integer id,
                                  @PathVariable("alternateId") Integer alternateId) {
        gameService.deleteAlternate(id, alternateId);
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
