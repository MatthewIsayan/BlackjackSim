package org.isayan.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.library.event.CardDealtEvent;
import org.isayan.library.event.Event;
import org.isayan.library.event.EventListener;
import org.isayan.library.event.IntiateGameEvent;
import org.isayan.library.utils.AnsiColor;

public class ConsoleEventListener implements EventListener {
    private static final Logger DEV_LOGGER = LogManager.getLogger(ConsoleEventListener.class);
    private static final Logger GAME_OUT_LOGGER = LogManager.getLogger("org.isayan.console.GameOutput");


    @Override
    public void listen(Event event) {
        DEV_LOGGER.trace("Consuming [{}] ", event.getClass().getSimpleName());
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(event instanceof CardDealtEvent cardDealtEvent) {
            if(cardDealtEvent.getCard().isFaceUp()) {
                GAME_OUT_LOGGER.info("Dealing [HIDDEN] to {}.", cardDealtEvent.getPerson().getName());
                DEV_LOGGER.debug("Hidden card is {}", cardDealtEvent.getCard());
            } else {
                GAME_OUT_LOGGER.info("Dealing {} to {}.", cardDealtEvent.getCard(), cardDealtEvent.getPerson().getName());

                if(cardDealtEvent.getCardNumber() >= 2)  {
                    // To add separation between players/events.
                    GAME_OUT_LOGGER.info("\n");
                }
            }
        } else if (event instanceof IntiateGameEvent intiateGameEvent) {
            GAME_OUT_LOGGER.info(formatGreenBold("Starting Blackjack Simulation with players {}\n"), intiateGameEvent.getGameState().getPlayers());
        }
    }

    private String formatGreenBold(String message) {
        return "%s%s%s".formatted(AnsiColor.boldGreen(), message, AnsiColor.reset());
    }
}
