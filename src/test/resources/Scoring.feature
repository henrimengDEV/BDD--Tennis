Feature: Player scoring

  Scenario: Players scores start at 0
    Given a new game
    Then players scores should be at "0"

  Scenario Outline: A player win a point
    Given "Nadal" had <actualScore> points
    And "Djokovic" had <opponentScore> points
    When "Nadal" won the point against "Djokovic"
    Then "Nadal" should have <expectedScore> points

    Examples:
      | opponentScore | actualScore | expectedScore |
      | "0"           | "0"         | "15"          |
      | "0"           | "15"        | "30"          |
      | "0"           | "30"        | "40"          |
      | "0"           | "deuce"     | "advantage"   |
      | "advantage"   | "deuce"     | "deuce"       |
      | "0"           | "advantage" | "0"           |

  Scenario: A player win the game
    Given "Nadal" had "40" points
    When "Nadal" won the point against "Djokovic"
    Then the winner should be "Nadal"

  Scenario: Players are deuce
    Given "Nadal" had "30" points
    And "Djokovic" had "40" points
    When "Nadal" won the point against "Djokovic"
    Then the players are "deuce"