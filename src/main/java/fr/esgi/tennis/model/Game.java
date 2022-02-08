package fr.esgi.tennis.model;

import java.util.Map;

public final class Game {

    private final Map<String, Player> players;
    private Player winner;

    private Game(Map<String, Player> players) {
        this.players = players;
    }

    public static Game of(Map<String, Player> players) {
        return new Game(players);
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

}
