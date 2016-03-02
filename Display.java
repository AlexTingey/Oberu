import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Alex on 11/14/2015.
 */
 public class Display extends JFrame implements ActionListener{
    public static void displayCard(Card card){
        //Will display the card with body, header and footer.
    }
    public static void displayMenu(){
        JFrame mainWindow = new JFrame(Card.forKapptie());
        mainWindow.setLayout(null);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(1000, 1000);
        mainWindow.setVisible(true);

        JLabel title = new JLabel(Card.forKapptie());
        title.setText(Card.forKapptie());
        title.setSize(200,200);
        title.setFont(new Font("Helvetica",1, 50));
        title.setLocation(450,50);
        title.setVisible(true);

        JPanel DeckMenuPanel = new JPanel();
        DeckMenuPanel.setLayout(null);
        JButton DeckMenu = new JButton("Create Deck");
        DeckMenu.setLayout(null);
        DeckMenu.setVisible(true);
        DeckMenu.setBounds(420, 200, 100, 100);
        DeckMenuPanel.setBounds(420, 200, 200, 100);
        DeckMenu.setSize(200, 50);
        DeckMenu.setLocation(0,0);
        DeckMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Another One");
            }
        });



        JButton studyButton = new JButton("Study Deck");
        studyButton.setLayout(null);
        studyButton.setVisible(true);
        studyButton.setBounds(700,200,100,100);
        studyButton.setBounds(700,200,200,100);
        studyButton.setSize(200,50);
        DeckMenu.setLocation(0,0);


        DeckMenuPanel.add(DeckMenu);
        DeckMenuPanel.add(studyButton);
        mainWindow.add(DeckMenuPanel);
        mainWindow.add(title);

        //Displays the menu you see when you start the application
    }
    public static void createCard(){
        //Displays the area where you can enter in data in a user friendly way to create new cards.
    }
    public static void createDeck(){
        //Shows where you can add all cards in one directory to a new deck.
    }
    public void actionPerformed(ActionEvent e){
        //dosomething
    }



}
