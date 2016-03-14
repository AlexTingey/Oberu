/**
 * Created by Alex on 11/14/2015.
 */
public class Card {
   protected String cardBody, cardHeader, cardFooter;
    protected int difficulty = 0;
    //Creates the Card Object.
    public Card(String body, String header, String footer, int challenge){
        //Decalres that a card is composed of a body, header, and footer that are all strings.
        cardBody = body;
        cardHeader = header;
        cardFooter = footer;
        difficulty = challenge;
    }
    public String GetBody(Card card){
        //returns the body, or the main substance, of the flash card.
        return card.cardBody;
    }
    public String GetHeader(Card card){
        //returns the header on the flashcard.
        return card.cardHeader;
    }
    public String GetFooter(Card card){
        //returns the footer on the flashcard.
        return card.cardFooter;
    }
    public void SaveCard(Card card){
        //saves the card to a text file located in the same directory as the jar File.
    }
    public void DeleteCard(Card card){
        //Deletes the card and wherever it has been placed.
    }
    public int getDifficulty(Card card){
        return card.difficulty;
    }
    public static void createCard(){
        //Displays the area where you can enter in data in a user friendly way to create new cards.
    }

    public static String forKapptie(){
        return "Oberu";
    }
}
