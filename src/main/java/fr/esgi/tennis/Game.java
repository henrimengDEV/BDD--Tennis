package fr.esgi.tennis;

import javax.management.InvalidAttributeValueException;
import java.util.Map;

public final class Game {

    public Map<String, Player> players;
    public Player winner;

    private Game() {
        this.winner = null;
    }

    public static Game of(Map<String, Player> players) {
        Game game = new Game();
        game.players = players;
        return game;
    }

    public void increaseScore(String winnerName, String opponentName) throws InvalidAttributeValueException {
        Player player = players.get(winnerName);
        Player opponent = players.get(opponentName);

        switch (player.score) {
            case LOVE:
                player.score = Score.FIFTEEN;
                break;
            case FIFTEEN:
                player.score = Score.THIRTY;
                break;
            case THIRTY:

                if (opponent.score == Score.FORTY) {
                    player.score = Score.DEUCE;
                    opponent.score = Score.DEUCE;
                    break;
                }

                player.score = Score.FORTY;
                break;
            case FORTY:
            case ADVANTAGE:
                player.score = Score.LOVE;
                this.winner = player;
                break;
            case DEUCE:

                if (opponent.score == Score.ADVANTAGE) {
                    opponent.score = Score.DEUCE;
                    break;
                }

                player.score = Score.ADVANTAGE;
                break;
            default:
                throw new InvalidAttributeValueException(player.score + " is impossible !");
        }
    }
}
