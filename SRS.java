/**
 * @author Alex
 * Created by Alex on 11/14/2015.
 *
 * The SRS class is the core of the program. This is the class that dictates
 * which flash cards the user sees based on how difficult the user ranks them.
 * The more difficult the user ranks a card to be, the more frequently it will appear to them
 * until they are eventually able to retain the card's information. If a user finds a card
 * to be particularly easy, the card will start appearing less and less until the user "Graduates"
 * and the card is never shown to them again.
 * This system is what differentiates Oberu from a typical flash card application.
 */
public class SRS {
    protected int difficulty = 0;

    public void sort(Deck deck){
        /**
         * @param deck
         * this method allows us to sort the deck in order of most difficult cards for the user first
         * to the easiest cards which will appear last.
         */
        }
    public static void demote(Card card){
        /**
         * @param card
         *Will take a card from a deck, and if the user happens to find the card easy, will make it so the card appears with less frequency.
         */
        card.difficulty --;
    }
    public static void promote(Card card){
        /**
         * @param card
         * Will demote the card if the user finds it to be very difficult, will increase the frequency with which the user sees the card.
         */
        card.difficulty ++;
    }
    public static void graduate(Card card){
        /**
         * @param card
         * If a card becomes incredibly easy for the user, and they consistently mark it as an easy card, the user will graduate from the card.
         * Cards that have been graduated from are shown at an incredibly low frequency.
         */
        card.difficulty = -100;
    }
}
