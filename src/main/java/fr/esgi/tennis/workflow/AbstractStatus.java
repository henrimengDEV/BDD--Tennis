package fr.esgi.tennis.workflow;

import fr.esgi.tennis.enumeration.Score;

public abstract class AbstractStatus {
    protected Score name;

    public Score getName() {
        return name;
    }

    public void setName(Score name) {
        this.name = name;
    }
}
