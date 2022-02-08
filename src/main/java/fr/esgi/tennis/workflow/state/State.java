package fr.esgi.tennis.workflow.state;

import fr.esgi.tennis.enumeration.Score;
import fr.esgi.tennis.model.Player;

public interface State {
    void next(Player p);

    void prev(Player p);

    Score getName();
}
