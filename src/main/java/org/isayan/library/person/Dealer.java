package org.isayan.library.person;

import org.isayan.library.model.Card;
import org.isayan.library.model.Hand;

import java.util.List;

public class Dealer implements Person {
    private final Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    public List<Card> getFaceupCards() {
        return hand.findFaceupCards();
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public String getName() {
        return "Dealer";
    }
}
