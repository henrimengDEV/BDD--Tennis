package fr.esgi.tennis.model;


import fr.esgi.tennis.workflow.state.State;
import fr.esgi.tennis.workflow.state.StateLove;

public final class Player {

    private final String name;
    private State score;

    public Player(String name) {
        this.name = name;
        score = new StateLove();
    }

    public String getName() {
        return name;
    }

    public State getScore() {
        return score;
    }

    public void setScore(State score) {
        this.score = score;
    }

    public void nextScore() {
        score.next(this);
    }

    public void prevScore() {
        score.prev(this);
    }

}
