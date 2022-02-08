Feature: Player scoring

  Scenario: Players scores start at 0
    Given a new game
    Then the players scores should be at 0

  @WinBall
  Scenario Outline: A player win the ball
    Given Nadal was at <actualScore>
    And Djokovic was at 0
    When Nadal won the point against Djokovic
    Then Nadal should have <expectedScore> points

    Examples:
      | actualScore | expectedScore |
      | 0           | 15            |
      | 15          | 30            |
      | 30          | 40            |

  @Deuce
  Scenario: the game become in deuce without advantage
    Given Nadal was at 30
    And Djokovic was at 40
    When Nadal won the point against Djokovic
    Then the players scores should be at deuce

  @Deuce
  Scenario: the player without advantage wins they are back at deuce
    Given Nadal was at deuce
    And Djokovic was at advantage
    When Nadal won the point against Djokovic
    Then Nadal should have deuce points
    Then Djokovic should have deuce points

  @Advantage
  Scenario: the game is in deuce, the winner of a point will have advantage
    Given Nadal was at deuce
    And Djokovic was at deuce
    When Nadal won the point against Djokovic
    Then Nadal should have advantage points
    Then Djokovic should have deuce points

  @WinGame
  Scenario: the player with advantage wins the ball he wins the game
    Given Nadal was at advantage
    And Djokovic was at deuce
    When Nadal won the point against Djokovic
    Then the winner should be Nadal

  @WinGame
  Scenario: A player win the game with at least two points more than the opponent
    Given Nadal was at 40
    When Nadal won the point against Djokovic
    Then the winner should be Nadal
