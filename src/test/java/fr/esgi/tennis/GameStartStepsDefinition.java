package fr.esgi.tennis;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Game;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.workflow.StateScoreFactory;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public final class GameStartStepsDefinition {
    private final Game game;

    public GameStartStepsDefinition(GameContext gameContext) {
        this.game = gameContext.game;
    }

    @ParameterType(".*")
    public Score score(String scoreValue) {
        return Score.of(scoreValue);
    }

    @ParameterType(".*")
    public Player player(String playerName) {
        Player player = game.getPlayers().get(playerName);
        if (player == null) {
            player = new Player(playerName);
            game.getPlayers().put(playerName, player);
        }
        return player;
    }

    @Given("start a new game with {player} vs {player}")
    public void start_a_new_game_with_player1_vs_player2(Player player1, Player player2) {
        this.game.getPlayers().get(player1.getName()).setScore(StateScoreFactory.getState(Score.LOVE));
        this.game.getPlayers().get(player2.getName()).setScore(StateScoreFactory.getState(Score.LOVE));
    }

    @Given("start a game with {player} at {score} and {player} at {score}")
    public void start_a_game_with_player1_at_score_and_player2_at(Player player1, Score scorePlayer1, Player player2, Score scorePlayer2) {
        this.game.getPlayers().get(player1.getName()).setScore(StateScoreFactory.getState(scorePlayer1));
        this.game.getPlayers().get(player2.getName()).setScore(StateScoreFactory.getState(scorePlayer2));
    }

    @Then("{player} score should be at {score}")
    public void player_score_should_be_At(Player player, Score score) {
        Assertions.assertEquals(score, this.game.getPlayers().get(player.getName()).getScore().getName());
    }


}
