package fr.esgi.tennis;

import fr.esgi.tennis.Game;
import fr.esgi.tennis.Player;
import fr.esgi.tennis.Score;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import javax.management.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.Map;

public final class ScoringStepDefinition {

    private Game game;

    @Before
    public void setUp() {
        Map<String, Player> players = new HashMap<>();
        players.put("Nadal", new Player("Nadal"));
        players.put("Djokovic", new Player("Djokovic"));
        this.game = Game.of(players);
    }

    @Given("a new game")
    public void a_new_game() {
        // this.game = new fr.esgi.tennis.Game();
    }

    @Then("players scores should be at {string}")
    public void players_scores_should_be_at(String expectedScore) {
        this.game.players.values().forEach(player -> Assertions.assertEquals(Score.of(expectedScore), player.score));
    }

    @Given("{string} is at {string}")
    public void the_player_is_at(String playerName, String actualScore) {
        this.game.players.get(playerName).score = Score.of(actualScore);
    }

    @When("{string} won the point against {string}")
    public void the_player_won_the_point(String playerName, String opponentName) throws InvalidAttributeValueException {
        this.game.increaseScore(playerName, opponentName);
    }

    @Then("{string} should have {string} points")
    public void the_player_should_have_expected_score_points(String playerName, String expectedScore) {
        Assertions.assertEquals(Score.of(expectedScore), this.game.players.get(playerName).score);
    }

    @Then("the winner should be {string}")
    public void the_winner_should_be(String name) {
        Assertions.assertEquals(name, this.game.winner.name);
    }

    @Then("the players are {string}")
    public void the_players_are_deuce(String expectedScore) {
        for (Player player : this.game.players.values()) {
            Assertions.assertEquals(Score.of(expectedScore), player.score);
        }
    }
}
