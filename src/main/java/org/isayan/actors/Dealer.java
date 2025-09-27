package org.isayan.actors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.model.Card;
import org.isayan.model.Hand;
import org.isayan.model.Shoe;

import java.util.List;

public class Dealer {
    private static final Logger LOGGER = LogManager.getLogger(Dealer.class);

    private final Hand hand;

    public Dealer() {
        this.hand = new Hand();
    }

    public Dealer(Hand hand) {
        this.hand = hand;
    }

    // TODO: Redo this to deal one card at a time to all Actors, maybe burn card
    public void dealInitialCardsForRound(Shoe shoe, List<Player> players) {
        if(players.isEmpty()) {
            throw new RuntimeException("Started round without player(s).");
        }

        for (Player player : players) {
            // Deal each player 2 cards
            Card card = shoe.dealTopCard();
            LOGGER.debug("Dealing 1st card {} to {}", card, player);
            player.addToHand(card);

            card = shoe.dealTopCard();
            LOGGER.debug("Dealing 2nd card {} to {}", card, player);
            player.addToHand(card);
        }

        // To the dealer, give one facedown card and one faceup card.
        Card faceupCard = shoe.dealTopCard();
        LOGGER.debug("Dealing {} as faceup to dealer", faceupCard);
        faceupCard.setFaceUp(true);
        hand.addCard(faceupCard);

        Card card = shoe.dealTopCard();
        LOGGER.debug("Dealing {} as facedown to dealer", card);
        hand.addCard(card);
    }

    public List<Card> getFaceupCards() {
        return hand.findFaceupCards();
    }
}
