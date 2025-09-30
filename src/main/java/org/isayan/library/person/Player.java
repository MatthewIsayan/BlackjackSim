package org.isayan.library.person;

import org.isayan.library.model.Hand;
import org.isayan.library.strategy.AlwaysHitStrategy;
import org.isayan.library.strategy.PlayerStrategy;
import org.isayan.library.utils.RandomNameGenerator;

public class Player implements Person {
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


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Hand getHand() {
        return hand;
    }
}
