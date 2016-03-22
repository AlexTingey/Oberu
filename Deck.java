import java.util.ArrayList;

/**
 * @author Alex
 * Created by Alex on 11/14/2015.
 *
 * A deck is a collection of cards.
 * Decks are important to the program, without them Oberu has no idea what card's to show.
 * Decks will also be sorted according to the SRS class's demands, making certain cards appear at different times depending on how difficult the user finds them.
 */
public class Deck {
    protected ArrayList<Card> deck;
    /**
     * @param cards
     */
    public Deck(ArrayList<Card> cards){
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
