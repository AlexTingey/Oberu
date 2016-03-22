/**
 * @author Alex
 * Created by Alex on 11/14/2015.
 *
 * This is where we wil define what a "card" is. A card is an object that has three strings: Body, Header, and Footer.
 * With these three strings the user is able to see all necessary information for the card.
 * It's essentially a flash card.
 */

public class Card {
    protected String cardBody, cardHeader, cardFooter;
    protected int difficulty = 0;
    /**
     *
     * @param body
     * @param header
     * @param footer
     * @param challenge
     */
    public Card(String body, String header, String footer, int challenge){
        cardBody = body;
        cardHeader = header;
        cardFooter = footer;
        difficulty = challenge;
    }

    public String GetBody(){
        /**
         * @return cardBody
         */
        return this.cardBody;
    }

    public String GetHeader(){
        /**
         * @return cardHeader
         */
        return this.cardHeader;
    }

    public String GetFooter(){
        /**
         * @return cardFooter
         */
        return this.cardFooter;
    }

    public void SaveCard(Card card){
        /**
         * This will save the card to a specific deck.
         */
    }

    public void DeleteCard(Card card){
        /**
         * This will delete the selected card.
         */
    }

    public void setCardBody(String cardBody){
        /**
         * This will allow us to set the card body.
         */
        this.cardBody = cardBody;
    }

    public void setCardHeader(String cardHeader){
        /**
         * This will allow us to set the card header to whatever we please.
         */
        this.cardHeader = cardHeader;
    }

    public void setCardFooter(String cardFooter){
        /**
         * This allows us to set the card footer as whatever we please.
         */
        //Sets the Card footer to a desired string
        this.cardFooter = cardFooter;
    }

    public void setDifficulty(int difficulty){
        /**
         * This sets the difficult of the card.
         */
        //Sets the difficulty of the Card
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        /**
         * @reutrn cardDifficulty returns the difficulty of the card
         */
        return this.difficulty;

    }

}
