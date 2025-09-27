package org.isayan.strategy;

import org.isayan.model.Card;
import org.isayan.model.Hand;
import org.isayan.game.Action;

/**
 * A probabilistically bad strategy to always hit used in demos.
 */
public class AlwaysHitStrategy implements PlayerStrategy {
    @Override
    public Action decide(Hand hand, Card dealerUpCard) {
        return Action.HIT;
    }
}
