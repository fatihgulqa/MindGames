Feature: Testing game cards

  Scenario: Creating a deck of 52 cards
    Given Create deck
    And Print out the deck
    When Shuffle the deck 100 times
    And Print out the shuffled deck
    Then Compare before and after shuffle deck

  Scenario: Deal some cards from deck
    Given For 3 player, deal cards
    And Check if they are same with the shuffled deck
    Then Deal 50 times more and check if you will get "Out of Card" message


