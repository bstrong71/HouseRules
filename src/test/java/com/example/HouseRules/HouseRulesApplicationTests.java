package com.example.HouseRules;

import com.example.HouseRules.model.Game;
import com.example.HouseRules.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static com.example.HouseRules.GameUtils.createGame;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseRulesApplicationTests {

	@Autowired
	GameService gameService;

	@Test
	public void testAddGame() throws Exception{
		Game game1 = createGame();
		Game game2 = createGame();


	}

}
