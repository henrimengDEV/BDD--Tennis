Feature: Player scoring

  @WinBall
  Scenario Outline: A player win the ball
    Given start a game with Nadal at <actualScore> and Djokovic at 0
    When Nadal won the point against Djokovic
    Then Nadal score should be at <expectedScore>

    Examples:
      | actualScore | expectedScore |
      | 0           | 15            |
      | 15          | 30            |
      | 30          | 40            |

  @Deuce
  Scenario: the game become in deuce without advantage
    Given start a game with Nadal at 30 and Djokovic at 40
    When Nadal won the point against Djokovic
    Then the players scores should be at deuce

  @Deuce
  Scenario: the player without advantage wins they are back at deuce
    Given start a game with Nadal at deuce and Djokovic at advantage
    When Nadal won the point against Djokovic
    Then the players scores should be at deuce

  @Advantage
  Scenario: the game is in deuce, the winner of a point will have advantage
    Given start a game with Nadal at deuce and Djokovic at deuce
    When Nadal won the point against Djokovic
    Then Nadal score should be at advantage
    Then Djokovic score should be at deuce

  @WinGame
  Scenario: the player with advantage wins the ball he wins the game
    Given start a game with Nadal at advantage and Djokovic at deuce
    When Nadal won the point against Djokovic
    Then the winner should be Nadal

  @WinGame
  Scenario: A player win the game with at least two points more than the opponent
    Given start a game with Nadal at 40 and Djokovic at 0
    When Nadal won the point against Djokovic
    Then the winner should be Nadal
