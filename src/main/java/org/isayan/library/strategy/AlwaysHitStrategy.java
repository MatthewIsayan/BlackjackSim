package org.isayan.library.strategy;

import org.isayan.library.model.Card;
import org.isayan.library.model.Hand;
import org.isayan.library.engine.Action;

/**
 * A probabilistically bad strategy to always hit used in demos.
 */
public class AlwaysHitStrategy implements PlayerStrategy {
    @Override
    public Action decide(Hand hand, Card dealerUpCard) {
        return Action.HIT;
    }
}
