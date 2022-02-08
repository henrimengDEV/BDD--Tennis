package fr.esgi.tennis.workflow.state;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.workflow.AbstractStatus;

public class StateAdvantage extends AbstractStatus implements State {
    public StateAdvantage() {
        name = Score.ADVANTAGE;
    }

    @Override
    public void next(Player p) {
        p.setScore(new StateLove());
    }

    @Override
    public void prev(Player p) {
        p.setScore(new StateDeuce());
    }
}
