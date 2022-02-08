package fr.esgi.tennis.workflow;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.workflow.state.*;

import java.util.EnumMap;
import java.util.Map;

public class StateScoreFactory {
    static Map<Score, State> statMapMap = new EnumMap<>(Score.class);

    static {
        statMapMap.put(Score.LOVE, new StateLove());
        statMapMap.put(Score.FIFTEEN, new StateFifteen());
        statMapMap.put(Score.THIRTY, new StateThirty());
        statMapMap.put(Score.FORTY, new StateForty());
        statMapMap.put(Score.DEUCE, new StateDeuce());
        statMapMap.put(Score.ADVANTAGE, new StateAdvantage());
    }

    private StateScoreFactory() {
        throw new IllegalStateException("StateScoreFactory class");
    }

    public static State getState(Score score) {
        return statMapMap.get(score);
    }
}
