package org.isayan.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private static final Logger LOGGER = LogManager.getLogger(Deck.class);

    private final List<Card> cards = new ArrayList<>();

    public Deck() {
        LOGGER.debug("Initializing deck of cards");
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        LOGGER.debug("Created deck of {} cards", size());
    }

    public int size() {
        return getCards().size();
    }

    @Override
    public String toString() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Card> getCards() {
        return cards;
    }
}
