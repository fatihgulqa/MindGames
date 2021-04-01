package MainClasses;

import MainClasses.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Deck {
    Logger logger = LoggerFactory.getLogger(Deck.class);
    public static final int NCARDS = 52;
    private Card[] deckOfCards;         // Contains all 52 cards
    private int currentCard;            // deal THIS card in deck

    public int getCurrentCard() {
        return currentCard;
    }

    public Deck()    // Constructor
    {
        deckOfCards = new Card[NCARDS];
        int i = 0;
        for (int suit = 1; suit <= 4; suit++) //MainClasses.Card.SPADES    MainClasses.Card.DIAMONDS
            for (int rank = 1; rank <= 13; rank++)
                deckOfCards[i++] = new Card(rank, suit);
        currentCard = 0;
    }

//    public void createDeck(){
//        deckOfCards = new Card[NCARDS];
//        int i = 0;
//        for (int suit = 1; suit <= 4; suit++) //MainClasses.Card.SPADES    MainClasses.Card.DIAMONDS
//            for (int rank = 1; rank <= 13; rank++)
//                deckOfCards[i++] = new Card(rank, suit);
//        currentCard = 0;
//
//    }
    /* ---------------------------------
          shuffle(n): shuffle the deck
          --------------------------------- */
    public void shuffle(int n) {
        int i, j, k;
        for (k = 0; k < n; k++) {
            i = (int) (NCARDS * Math.random());  // Pick 2 random cards
            j = (int) (NCARDS * Math.random());  // in the deck
   	     /* ---------------------------------
   		swap these randomly picked cards
   		--------------------------------- */
            Card tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
            ;
        }
        currentCard = 0;   // Reset current card to deal
    }

    /* -------------------------------------------
      deal(): deal deckOfCards[currentCard] out
      ------------------------------------------- */
    public Card deal() {
        if (currentCard < NCARDS) {
            return (deckOfCards[currentCard++]);
        } else {
            logger.info("Out of cards");
            return (null);  // Error;
        }
    }

// Will print all the deck
    public String toString() {
        String s = "";
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                s += deckOfCards[k].suitToString(deckOfCards[k].getSuit()) + "-" +deckOfCards[k].rankToString(deckOfCards[k].getRank())+ ", ";
                k++;
            }
            s += "\n";
        }
        return s;
    }
}
