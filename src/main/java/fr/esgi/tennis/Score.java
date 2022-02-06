package fr.esgi.tennis;

public enum Score {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    DEUCE("deuce"),
    ADVANTAGE("advantage");

    public String value;
    Score(String value) {
        this.value = value;
    }

    public static Score of(String value) {

        for (Score score : Score.values()) {
            if (score.value.equalsIgnoreCase(value))
                return score;
        }

        throw new IllegalArgumentException();
    }
}