/**
 * Created by Alex on 11/14/2015.
 */
public class SRS {
    protected int difficulty = 0;
    public void sort(Deck deck){
        //Sorts Cards in the needed order, this will follow a specific algorithm to ensure that the flash cards you are bad at are seen more often.
        //Runs every time a deck is opened.
    }
    public static void demote(Card card){
        //Will take a card from a deck, and if the user happens to find the card easy, will make it so the card appears with less frequency.
        card.difficulty --;
    }
    public static void promote(Card card){
        //Will demote the card if the user finds it to be very difficult, will increase the frequency with which the user sees the card.
        card.difficulty ++;
    }
    public static void graduate(Card card){
        //If a card becomes incredibly easy for the user, and they consistently mark it as an easy card, the user will graduate from the card. Cards that have been graduated from are shown at an incredibly low frequency.
        card.difficulty = -100;
    }
}
