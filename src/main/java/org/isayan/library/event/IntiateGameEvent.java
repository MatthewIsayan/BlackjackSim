package org.isayan.library.event;

import org.isayan.library.engine.GameState;

public class IntiateGameEvent implements Event {
    private final GameState gameState;

    public IntiateGameEvent(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }
}
