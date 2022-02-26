package fr.esgi.tennis;

import fr.esgi.tennis.model.Game;

import java.util.HashMap;

public final class GameContext {
    final Game game = Game.of(new HashMap<>());
}
