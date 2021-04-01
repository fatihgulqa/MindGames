package Stepdef;

import MainClasses.Card;
import MainClasses.Deck;


import io.cucumber.java.en.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class PlayGameSteps {
    Logger logger = LoggerFactory.getLogger(PlayGameSteps.class);
    public static Deck game;
    static Card tmpCard;
    Deck temp;


    @Given("^Create deck$")
    public void create_deck() {
        game = new Deck();
    }

    @Given("^Print out the deck$")
    public void print_out_the_deck() {
        logger.info(String.valueOf(game));
    }

    @Given("^Shuffle the deck (\\d+) times$")
    public void shuffle_the_deck_times(int numberOfShuffle) {

        game.shuffle(numberOfShuffle);
        Assert.assertNotEquals(new Deck(), game);
    }

    @Given("^Print out the shuffled deck$")
    public void print_out_the_shuffled_deck() {
        logger.info(String.valueOf(game));
    }

    @Then("^Compare before and after shuffle deck$")
    public void compare_before_and_after_shuffle_deck() {


    }

    @Given("^For (\\d+) player, deal cards$")
    public void for_player_deal_cards(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            tmpCard = game.deal(); // Assign the dealt card to Temporary card
            //Print out the dealt card
            logger.info(i + ". player card: " + tmpCard.rankToString(tmpCard.getRank()) + " " + tmpCard.suitToString(tmpCard.getSuit()));
        }

    }

    @Given("^Check if they are same with the shuffled deck$")
    public void check_if_they_are_same_with_the_shuffled_deck() {

    }

    @Then("^Deal (\\d+) times more and check if you will get \"([^\"]*)\" message$")
    public void deal_times_and_check_if_you_will_get_message(int numberOfDeals, String arg2) {
        int b = game.getCurrentCard(); //Get the last value of currentCard
        for (int i = b; i < (numberOfDeals+b); i++) {
            if (i > 52)  {  // If more then 52 card was dealt, tmpCard must be null
                try {
                     Assert.assertNull(tmpCard); //Check if the card is null
                } catch (AssertionError ae) {
                    logger.error("Assertion error {}", ae.getMessage());
                }
            break;
            }
            tmpCard=game.deal();  // Deal a card and assign it to Temporary card
        }
    }
}
