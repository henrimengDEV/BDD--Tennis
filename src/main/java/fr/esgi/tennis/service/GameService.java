package fr.esgi.tennis.service;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Game;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.workflow.state.StateDeuce;

import javax.management.InvalidAttributeValueException;
import java.util.Objects;

public final class GameService {

    public void increaseScore(Player player, Player opponent, Game game) throws InvalidAttributeValueException {

        switch (player.getScore().getName()) {
            case LOVE:
            case FIFTEEN:
                player.nextScore();
                break;
            case THIRTY:
                if (Objects.equals(opponent.getScore().getName(), Score.FORTY)) {
                    player.setScore(new StateDeuce());
                    opponent.setScore(new StateDeuce());
                    break;
                }
                player.nextScore();
                break;
            case FORTY:
            case ADVANTAGE:
                player.nextScore();
                game.setWinner(player);
                break;
            case DEUCE:
                if (Objects.equals(opponent.getScore().getName(), Score.ADVANTAGE)) {
                    opponent.prevScore();
                    break;
                }
                player.nextScore();
                break;
            default:
                throw new InvalidAttributeValueException(player.getScore().getName() + " is impossible !");
        }
    }
}
