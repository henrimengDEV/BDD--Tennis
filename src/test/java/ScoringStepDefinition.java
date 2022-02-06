import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import javax.management.InvalidAttributeValueException;

public final class ScoringStepDefinition {

    private Game game = new Game();

    @Given("a new game")
    public void a_new_game() {
        this.game = new Game();
    }

    @Then("players scores should be at {string}")
    public void players_scores_should_be_at(String expectedScore) {
        this.game.players.values().forEach(player -> Assertions.assertEquals(Score.of(expectedScore), player.score));
    }

    @Given("{string} had {string} points")
    public void the_player_had_actual_score_points(String playerName, String actualScore) {
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
