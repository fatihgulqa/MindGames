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

    // Constructor creates the deck of 52 cards
    public Deck()
    {
        deckOfCards = new Card[NCARDS];
        int i = 0;
        for (int suit = 1; suit <= 4; suit++)
            for (int rank = 1; rank <= 13; rank++)
                deckOfCards[i++] = new Card(rank, suit);
        currentCard = 0;
    }
  //An alternative way to create the deck with a method
//        public void createDeck(){
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
          It peaks two card from the deck randomly and swap them.
          To get  fully shuffled deck, at least 26 times it should be shuffled
          --------------------------------- */
    public void shuffle(int n) {
        int i, j, k;
        for (k = 0; k < n; k++) {
            i = (int) (NCARDS * Math.random());
            j = (int) (NCARDS * Math.random());
            Card tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
            ;
        }
        currentCard = 0;   // Reset current card to deal
    }

    /* -------------------------------------------
      deal(): deal deckOfCards[currentCard] out
      In every deal it returns a card from deck and increase the counter
      of Current Card
      ------------------------------------------- */
    public Card deal() {
        if (currentCard < NCARDS) {
            return (deckOfCards[currentCard++]);
        } else {
            logger.info("Out of cards");
            return (null);
        }
    }
        /* -------------------------------------------
       Will print all the deck as Suit-Rank
       This is used to print out the deck before and after
       the shuffle to see if shuffle works or not
      ------------------------------------------- */
    public String toString() {
        String s = "";
        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                s += deckOfCards[k].suitToString(deckOfCards[k].getSuit()) +
                        "-" + deckOfCards[k].rankToString(deckOfCards[k].getRank()) + ", ";
                k++;
            }
            s += "\n";
        }
        return s;
    }
}
