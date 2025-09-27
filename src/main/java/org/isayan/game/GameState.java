package org.isayan.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.isayan.actors.Dealer;
import org.isayan.actors.Player;
import org.isayan.model.Shoe;
import org.isayan.shuffle.RandomShuffler;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private static final Logger LOGGER = LogManager.getLogger(GameState.class);

    private final Shoe shoe;
    private final List<Player> players;
    private final Dealer dealer;

    public GameState(int numberOfDecks) {
        shoe = Shoe.generateShoeOfNDecks(numberOfDecks);
        shoe.shuffle(new RandomShuffler());
        players = new ArrayList<>();
        dealer = new Dealer();
    }

    public void seatPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Shoe getShoe() {
        return shoe;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }
}
