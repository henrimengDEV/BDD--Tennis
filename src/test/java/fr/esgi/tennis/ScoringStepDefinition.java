package fr.esgi.tennis;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Game;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.service.GameService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import javax.management.InvalidAttributeValueException;

public final class ScoringStepDefinition {
    private final Game game;
    private GameService gameService;

    public ScoringStepDefinition(GameContext gameContext) {
        this.game = gameContext.game;
    }

    @Before
    public void setUp() {
        gameService = new GameService();
    }

    @When("{player} won the point against {player}")
    public void the_player_won_the_point(Player playerName, Player opponentName) throws InvalidAttributeValueException {
        this.gameService.increaseScore(playerName, opponentName, game);
    }

    @Then("the players scores should be at {score}")
    public void players_scores_should_be_at(Score expectedScore) {
        this.game.getPlayers().values().forEach(player -> Assertions.assertEquals(expectedScore, player.getScore().getName()));
    }

    @Then("the winner should be {player}")
    public void the_winner_should_be(Player player) {
        Assertions.assertEquals(player.getName(), this.game.getWinner().getName());
    }
}
