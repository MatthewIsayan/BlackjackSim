package org.isayan.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }
    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public boolean addCard(Card card) {
        return cards.add(card);
    }

    public void clearHand() {
        cards.clear();
    }

    public List<Card> findFaceupCards() {
        return cards.stream()
                .filter(Card::isFaceUp)
                .toList();
    }
}
