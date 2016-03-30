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
        /**
         * @param directory
         *
         * This create deck method is able to be passed a String "Directory" and once it is given this directory
         * it is able to read the files there, transform them into cards and then add them into the deck to be displayed.
         */
        int difficulty;
        ArrayList<Card> deck = new ArrayList<>();
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
                String rawCardData = FileUtils.readFileToString(card, "UTF-8");
                String[] processedCardData = rawCardData.split("\\r?\\n");
                String header = processedCardData[0];
                System.out.println(header);
                String body = processedCardData[1];
                System.out.println(body);
                String footer = processedCardData[2];
                System.out.println(footer);
                /*This checks to make sure that the file contains the 4th line of the text document
                This line is important because without it the program cannot function properly, so if it finds that that line is missing or
                that the line contains any data that isn't a number it removes that line and turns it into a 0, allowing the card to be read and displayed properly.
                 */
                if(processedCardData.length < 4 || !processedCardData[3].matches("^[0-9]")){
                    System.out.println("test");
                    FileUtils.deleteQuietly(textFiles[i]);
                    for(int j = 0; j < 4; j++){
                        if(j == 3){
                            System.out.println("test3");
                            FileUtils.writeStringToFile(textFiles[i], "0", "UTF-8", true);
                        }
                        else{
                            System.out.println("test2");
                            FileUtils.writeStringToFile(textFiles[i], processedCardData[j], "UTF-8", true);
                            FileUtils.writeStringToFile(textFiles[i], System.lineSeparator(), "UTF-8", true);
                        }
                    }
                    difficulty = 0;
                }
                else{
                     difficulty = Integer.parseInt(processedCardData[3]);
                }
                String filePath = textFiles[i].getAbsolutePath();
                System.out.println("DECK ABS FILE PATH: " + filePath);
                Card cardN = new Card(header,body,footer,difficulty,filePath);
                if(cardN.getDifficulty() >= 150){
                    System.out.println("Card " + cardN.getBody() + " no longer needs to be studied");
                }
                else{
                    deck.add(cardN);
                }
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "IOException: " + e.getMessage());
                System.out.println(e.getMessage());
            }

        }
        return deck;
    }
    public ArrayList<Card> sortedDeck(Deck deck){
        /**
         * @param deck
         *
         * This method takes in a deck and returns it as a sorted ArrayList full of cards, these cards are sorted with the most
         * difficult appearing cards appearing both first and last. A card qualifies as "difficult" if it's difficulty level is less
         * than 100.
         */
        ArrayList<Card> aDeck = deck.getDeck();
        Collections.sort(aDeck, new Card());
        int startingSize = aDeck.size();
        for(int i = 0; i < startingSize; i++){
            if(aDeck.get(i).getDifficulty() < 100){
                aDeck.add(aDeck.get(i));
            }
        }
        return aDeck;
    }

}
