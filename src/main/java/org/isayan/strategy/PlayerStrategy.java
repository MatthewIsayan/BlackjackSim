package org.isayan.strategy;

import org.isayan.model.Card;
import org.isayan.model.Hand;
import org.isayan.game.Action;

public interface PlayerStrategy {
    Action decide(Hand hand, Card dealerUpCard);
}
