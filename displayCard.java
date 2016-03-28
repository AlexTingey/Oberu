import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Alex
 * Created by Alex on 3/22/2016.
 *
 * This class will be used to display the cards that the user will see and interact with in order
 * to study.
 */
public class displayCard {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JLabel header;
    private JLabel body;
    private JFileChooser fileChooser;
    private JButton openButton;
    private JLabel footer;
    private Card displayedCard = new Card("","","",0,"");
    private int cardWereOn = 0;
    private String filedir = fileSelect();
    private Deck deck = new Deck(filedir);
    ArrayList<Card> sortDeck = deck.sortedDeck(deck);
    /**
     *Here we create our JFrame (mainFrame), our JPanel to hold the buttons (controlPanel),
     * and a couple Labels that we will use in order to display information.
     */
    public void prepareGUI(){
        /**
         * Prepare GUI is where we lay out all of the non-interactive elements of the GUI. Things like
         * the card's information are displayed here.
         */
        displayedCard.setCardHeader(sortDeck.get(cardWereOn).getHeader());
        displayedCard.setCardBody(sortDeck.get(cardWereOn).getBody());
        displayedCard.setCardFooter(sortDeck.get(cardWereOn).getFooter());
       /* else if(cardWereOn < sortDeck.size()){
            JOptionPane.showMessageDialog(null, "There are no more cards to study in this directory");
        }*/
        Font helveticaB = new Font("Helvetica", Font.BOLD, 50);
        Font helveticaM = new Font("Helvetica", Font.BOLD, 25);
        mainFrame = new JFrame("Study");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(4, 3));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JLabel(displayedCard.getHeader(), JLabel.CENTER);
        header.setFont(helveticaM);

        body = new JLabel(displayedCard.getBody(), JLabel.CENTER);
        body.setFont(helveticaB);

        footer = new JLabel(displayedCard.getFooter(), JLabel.CENTER);
        footer.setFont(helveticaM);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(header);
        mainFrame.add(body);
        mainFrame.add(footer);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        event();
    }
    public void event(){
        /**
         * This method is where we lay out all of the interactive elements of the GUI. The Buttons are placed onto the JPanel and ascribed
         * an Action Listener.
         */
        JButton easy = new JButton("Easy");
        JButton difficult = new JButton("Difficult");
        JButton ok = new JButton("Ok");

        easy.setActionCommand("easy");
        ok.setActionCommand("ok");
        difficult.setActionCommand("difficult");

        easy.addActionListener(new ButtonClickerListener());
        difficult.addActionListener(new ButtonClickerListener());
        ok.addActionListener(new ButtonClickerListener());

        controlPanel.add(easy);
        controlPanel.add(ok);
        controlPanel.add(difficult);
    }
    public String fileSelect(){
        /**
         *File select is a method that creates the file selection menu seen when clicking on the study button.
         * It was almost it's own class but then I decided that I could just implement it as a method within the display class, since the main menu is the only time the user would need to select anything.
         *@return deckLocation The location of the deck we want to study/create
         */
        openButton = new JButton();
        fileChooser = new JFileChooser();
        fileChooser.setVisible(true);
        fileChooser.setDialogTitle("Select Deck Location");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fileChooser.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION){
            String deckLocation = fileChooser.getSelectedFile().getAbsolutePath();
            return deckLocation;
        }
        return "";
    }

    private class ButtonClickerListener implements ActionListener{
        /**
         * Here we have our ButtonClick action listener.
         * This is what adds the responses for the buttons to our program.
         * Using this we are able to implement the SRS system into Oberu, which is important
         * because without the SRS system it is just a flash card application.
         *
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("easy")){
                if(cardWereOn < sortDeck.size() -1){
                    mainFrame.setVisible(false);
                    sortDeck.get(cardWereOn).easy();
                    cardWereOn ++;
                    prepareGUI();
                }
                else{
                    mainFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You have studied all of the cards in this deck!");
                    Display display = new Display();
                    display.prepareGUI();
                }

            }
            if(command.equals("ok")){
                if(cardWereOn < sortDeck.size() -1 ){
                    mainFrame.setVisible(false);
                    sortDeck.get(cardWereOn).easy();
                    cardWereOn ++;
                    prepareGUI();
                }
                else{
                    mainFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You have studied all of the cards in this deck!");
                    Display display = new Display();
                    display.prepareGUI();
                }

            }
            else if(command.equals("difficult")){
                if(cardWereOn < sortDeck.size() -1 ){
                    mainFrame.setVisible(false);
                    sortDeck.get(cardWereOn).easy();
                    cardWereOn ++;
                    prepareGUI();
                }
                else{
                    mainFrame.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You have studied all of the cards in this deck!");
                    Display display = new Display();
                    display.prepareGUI();
                }
            }
        }
    }
}
