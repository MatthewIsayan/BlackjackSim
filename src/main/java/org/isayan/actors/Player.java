package org.isayan.actors;

import org.isayan.model.Card;
import org.isayan.model.Hand;
import org.isayan.strategy.AlwaysHitStrategy;
import org.isayan.strategy.PlayerStrategy;
import org.isayan.utils.RandomNameGenerator;

public class Player {
    private final Hand hand;
    private final String name = new RandomNameGenerator().randomFullName();
    private PlayerStrategy playerStrategy = new AlwaysHitStrategy(); // TODO: update Default

    public Player() {
        this.hand = new Hand();
    }

    public Player(PlayerStrategy playerStrategy) {
        this.hand = new Hand();
        this.playerStrategy = playerStrategy;
    }

    public Player(Hand hand) {
        this.hand = hand;
    }

    public void addToHand(Card card) {
        hand.addCard(card);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
