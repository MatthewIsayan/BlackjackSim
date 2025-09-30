package org.isayan.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.library.event.EventBus;
import org.isayan.library.person.Player;
import org.isayan.library.engine.GameEngine;
import org.isayan.library.engine.GameState;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    static void main() {
        LOGGER.info("Blackjack!");

        int numOfDecks = 6;
        GameState gameState = new GameState(numOfDecks);

        gameState.seatPlayer(new Player());
        gameState.seatPlayer(new Player());

        EventBus eventBus = new EventBus();
        eventBus.subscribe(new ConsoleEventListener());

        new GameEngine(gameState, eventBus).startGame();
    }
}
