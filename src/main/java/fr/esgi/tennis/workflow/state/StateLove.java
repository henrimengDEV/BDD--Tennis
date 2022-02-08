package fr.esgi.tennis.workflow.state;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.exceptions.ChangeScoreImpossibleException;
import fr.esgi.tennis.exceptions.CodeMessage;
import fr.esgi.tennis.model.Player;
import fr.esgi.tennis.workflow.AbstractStatus;

public class StateLove extends AbstractStatus implements State {
    public StateLove() {
        name = Score.LOVE;
    }

    @Override
    public void next(Player p) {
        p.setScore(new StateFifteen());
    }

    @Override
    public void prev(Player p) {
        throw new ChangeScoreImpossibleException(CodeMessage.CHANGEMENT_SCORE_IMPOSSIBLE);
    }
}
