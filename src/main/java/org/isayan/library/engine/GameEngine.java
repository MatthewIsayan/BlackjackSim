package org.isayan.library.engine;

import org.isayan.library.command.Command;
import org.isayan.library.command.DealInitialCommand;
import org.isayan.library.event.EventBus;
import org.isayan.library.event.EventListener;
import org.isayan.library.event.IntiateGameEvent;

import java.util.List;

public class GameEngine {
    private final GameState state;
    private final EventBus eventBus;
    private List<Command> gameCommands;

    public GameEngine(GameState state, EventBus eventBus) {
        this.state = state;
        this.eventBus = eventBus;
    }

    public void startGame() {
        eventBus.publish(new IntiateGameEvent(state));
        gameCommands = List.of(new DealInitialCommand(eventBus));
        gameCommands.forEach(cmd -> cmd.execute(state));

//        startBettingPhase();
//        dealInitialCards();
//        handlePlayerTurns();
//        handleDealerTurn();
//        resolveBets();

    }

}
