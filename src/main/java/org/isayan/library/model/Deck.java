package org.isayan.library.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Stack;
import java.util.stream.Collectors;

public class Deck {
    private static final Logger LOGGER = LogManager.getLogger(Deck.class);

    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        LOGGER.debug("Created deck of {} cards", numberOfCards());
    }

    public int numberOfCards() {
        return getCards().size();
    }

    @Override
    public String toString() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
