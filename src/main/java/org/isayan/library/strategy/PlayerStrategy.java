package org.isayan.library.strategy;

import org.isayan.library.model.Card;
import org.isayan.library.model.Hand;
import org.isayan.library.engine.Action;

public interface PlayerStrategy {
    Action decide(Hand hand, Card dealerUpCard);
}
