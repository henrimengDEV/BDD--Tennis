package fr.esgi.tennis.exceptions;


public class ChangeScoreImpossibleException extends RuntimeException {

    public ChangeScoreImpossibleException(String message) {
        super(message);
    }

    public ChangeScoreImpossibleException(String message, Throwable cause) {
        super(message, cause);
    }
}
