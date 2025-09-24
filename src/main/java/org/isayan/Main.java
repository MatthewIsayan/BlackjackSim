package org.isayan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.cards.Deck;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    static void main() {
        LOGGER.info("Blackjack!");

        Deck deck = new Deck();
        LOGGER.info("New deck of {} cards\n{}", deck.size(), deck);
    }
}
