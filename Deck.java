import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;

/**
 * @author Alex
 * Created by Alex on 11/14/2015.
 *
 * A deck is a collection of cards.
 * Decks are important to the program, without them Oberu has no idea what card's to show.
 * Decks will also be sorted according to the SRS class's demands, making certain cards appear at different times depending on how difficult the user finds them.
 */
public class Deck {
    private ArrayList<Card> deck;
    /**
     * @param cards
     */
    public Deck(ArrayList<Card> cards){
        deck = cards;
    }
    public Deck(String directory){
        deck = createDeck(directory);
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> createDeck(String directory){
        ArrayList<Card> deck = new ArrayList<Card>();
        FilenameFilter filter = new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name){
                return name.endsWith(".txt");
            }
        };
        File folder = new File(directory);
        File[] textFiles = folder.listFiles(filter);
        for(int i = 0; i < textFiles.length; i++){
            File card = textFiles[i];
            try{
                String rawCardData = FileUtils.readFileToString(card);
                String[] processedCardData = rawCardData.split("\\r?\\n");
                String header = processedCardData[0];
                System.out.println(header);
                String body = processedCardData[1];
                System.out.println(body);
                String footer = processedCardData[2];
                System.out.println(footer);
                int difficulty = Integer.parseInt(processedCardData[3]);
                String filePath = textFiles[i].getAbsolutePath();
                System.out.println("DECK ABS FILE PATH: " + filePath);
                Card cardN = new Card(header,body,footer,difficulty,filePath);
                deck.add(cardN);
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage());
                System.out.println(e.getMessage());
            }

        }
        return deck;
    }
    public void addCard(Card card){
        //adds the card to the deck
    }
    public void removeCard(Card card){
        //removes the card from the deck.

    }
    public ArrayList<Card> sortedDeck(Deck deck){
        ArrayList<Card> aDeck = deck.getDeck();
        Collections.sort(aDeck, new Card());
        return aDeck;
    }

}
