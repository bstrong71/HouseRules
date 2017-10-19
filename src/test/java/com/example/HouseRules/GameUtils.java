package com.example.HouseRules;

import com.example.HouseRules.model.Game;


public class GameUtils {

    public static Game createGame() {
        // Give unique name every time test runs
        String title = Long.toString(System.currentTimeMillis());
        String category = Long.toString(System.currentTimeMillis());
        String objective = Long.toString(System.currentTimeMillis());
        String rules = Long.toString(System.currentTimeMillis());
        String numberOfPlayers = Long.toString(System.currentTimeMillis());
        String playerAgeRange = Long.toString(System.currentTimeMillis());
        byte[] image = null;

        Game game = new Game();
        game.setTitle(title);
        game.setCategory(category);
        game.setObjective(objective);
        game.setRules(rules);
        game.setNumberOfPlayers(numberOfPlayers);
        game.setPlayerAgeRange(playerAgeRange);
        game.setImage(image);

        return game;
    }


}
