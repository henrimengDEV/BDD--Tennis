Feature: Game start definition

  Scenario: Start new game definition
    Given start a new game with Nadal vs Djokovic
    Then Nadal score should be at 0
    Then Djokovic score should be at 0

  Scenario: Start a game with Nadal at 40 and Djokovic at 30
    Given start a game with Nadal at 40 and Djokovic at 30
    Then Nadal score should be at 40
    Then Djokovic score should be at 30