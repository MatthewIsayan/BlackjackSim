package org.isayan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.actors.Player;
import org.isayan.game.GameEngine;
import org.isayan.game.GameState;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    static void main() {
        LOGGER.info("Blackjack!");

        int numOfDecks = 6;
        GameState gameState = new GameState(numOfDecks);

        gameState.seatPlayer(new Player());
        gameState.seatPlayer(new Player());

        new GameEngine(gameState).playRound();
    }
}
