package fr.esgi.tennis;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Game;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.service.GameService;
import fr.esgi.tennis.workflow.StateScoreFactory;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import javax.management.InvalidAttributeValueException;
import java.util.HashMap;

public final class ScoringStepDefinition {

    private GameService gameService;
    private Game game;

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

    @Before
    public void setUp() {
        game = Game.of(new HashMap<>());
        gameService = new GameService();
    }

    @Given("a new game")
    public void a_new_game() {
        game = Game.of(new HashMap<>());
    }

    @Then("the players scores should be at {score}")
    public void players_scores_should_be_at(Score expectedScore) {
        this.game.getPlayers().values().forEach(player -> Assertions.assertEquals(expectedScore, player.getScore().getName()));
    }

    @Given("{player} was at {score}")
    public void the_player_was_at(Player player, Score actualScore) {
        this.game.getPlayers().get(player.getName()).setScore(StateScoreFactory.getState(actualScore));
    }

    @When("{player} won the point against {player}")
    public void the_player_won_the_point(Player playerName, Player opponentName) throws InvalidAttributeValueException {
        this.gameService.increaseScore(playerName, opponentName, game);
    }

    @Then("{player} should have {score} points")
    public void the_player_should_have_expected_score_points(Player player, Score expectedScore) {
        Assertions.assertEquals(expectedScore, this.game.getPlayers().get(player.getName()).getScore().getName());
    }

    @Then("the winner should be {player}")
    public void the_winner_should_be(Player player) {
        Assertions.assertEquals(player.getName(), this.game.getWinner().getName());
    }

}
