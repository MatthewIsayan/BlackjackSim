package org.isayan.library.command;

import org.isayan.library.person.Dealer;
import org.isayan.library.person.Player;
import org.isayan.library.engine.GameState;
import org.isayan.library.event.CardDealtEvent;
import org.isayan.library.event.EventBus;
import org.isayan.library.model.Card;
import org.isayan.library.model.Hand;
import org.isayan.library.model.Shoe;

import java.util.List;

public class DealInitialCommand implements Command {
    private final EventBus eventBus;

    public DealInitialCommand(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void execute(GameState gameState) {
        dealInitialCardsForRound(gameState.getShoe(), gameState.getDealer(), gameState.getPlayers());
    }


    // TODO: Redo this to deal one card at a time to all Actors, maybe burn card
    private void dealInitialCardsForRound(Shoe shoe, Dealer dealer, List<Player> players) {
        // TODO : Move exception to engine
        if(players.isEmpty()) {
            throw new RuntimeException("Started round without player(s).");
        }

        for (Player player : players) {
            Hand playerHand = player.getHand();

            // Deal each player 2 cards
            Card card = shoe.dealTopCard();
            playerHand.addCard(card);

            eventBus.publish(new CardDealtEvent(player, card, 1));

            card = shoe.dealTopCard();
            playerHand.addCard(card);

            eventBus.publish(new CardDealtEvent(player, card, 2));
        }

        // To the dealer, give one facedown card and one faceup card.
        Card faceupCard = shoe.dealTopCard();
        faceupCard.setFaceUp(true);
        dealer.getHand().addCard(faceupCard);

        eventBus.publish(new CardDealtEvent(dealer, faceupCard, 1));


        Card card = shoe.dealTopCard();
        dealer.getHand().addCard(card);

        eventBus.publish(new CardDealtEvent(dealer, card, 2));
    }
}
