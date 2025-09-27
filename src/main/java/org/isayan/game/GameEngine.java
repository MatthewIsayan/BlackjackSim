package org.isayan.game;

public class GameEngine {
    private final GameState state;

    public GameEngine(GameState state) {
        this.state = state;
    }

    public void playRound() {
//        startBettingPhase();
        dealInitialCards();
//        handlePlayerTurns();
//        handleDealerTurn();
//        resolveBets();
    }

    private void startBettingPhase() {

    }

    private void dealInitialCards() {
        state.getDealer().dealInitialCardsForRound(state.getShoe(), state.getPlayers());
    }
}
