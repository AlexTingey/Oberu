import java.util.ArrayList;

/**
 * Created by Alex on 11/14/2015.
 */
public class Deck {
    protected ArrayList<Card> deck;
    public Deck(ArrayList<Card> cards){
        // a deck is an arraylist of Cards, that will be edited and changed around on an as needed basis.
        deck = cards;
    }
    public void createDeck(Deck deck){
        //Will create a directory full of cards known as a "Deck".
    }
    public void addCardTo(Card card){
        //adds the card to the deck
    }
    public void removeCardFrom(Card card){
        //removes the card from the deck.

    }
}
