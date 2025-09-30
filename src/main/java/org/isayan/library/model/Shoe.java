package org.isayan.library.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.library.exceptions.NotImplementedException;
import org.isayan.library.shuffle.Shuffler;

import java.util.ArrayList;
import java.util.List;

public class Shoe {
    private static final Logger LOGGER = LogManager.getLogger(Shoe.class);

    private final List<Card> cards;

    private Shoe(List<Card> cards) {
        this.cards = cards;
    }

    public Card dealTopCard() {
        if (cards.isEmpty()) {
            LOGGER.debug("Initiating reshoe/reshuffle");
            throw new NotImplementedException("Shoe is empty. Reshoe not implemented");
        }
        return cards.removeFirst(); // or remove(0)
    }

    public void shuffle(Shuffler shuffler) {
        shuffler.shuffle(cards);
    }

    public static Shoe generateShoeOfNDecks(int numberOfDecks) {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < numberOfDecks; i++) {
            cardList.addAll(new Deck().getCards());
        }
        return new Shoe(cardList);
    }
}

