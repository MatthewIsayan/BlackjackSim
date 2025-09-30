package org.isayan.library.command;

import org.isayan.library.engine.GameState;

public interface Command {
    void execute(GameState gameState);
}
