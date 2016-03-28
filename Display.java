import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Alex
 * Created by Alex on 3/17/2016.
 *
 * I created the display class before I had any idea how a GUI in Java worked. As a result it has a terrible name.
 * The "Display" class is really just the main menu. When user's open up the application this is where they will be taken first.
 * This is an extremely important class because if it malfunctions then the user has no way to navigate to the other parts of the program.
 */

public class Display {
    private JFrame mainFrame;
    private JLabel header;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JFileChooser fileChooser;
    private JButton openButton;
    /**
     *Here we define the JFrame window (mainFrame), a header and status label, the JPanel where we will have our buttons (controlPanel), and a JButton "open button".
     * The interesting variable here is the JFileChooser fileChooser, this is an important variable because it is what allows the program to fetch the location of the deck it's supposed to be in.
     */
    public void prepareGUI(){
        /**
         * PrepareGUI is made to flesh out the constants of the GUI. What non interactive elements are going to be seen on the application.
         */
        Font helvetica = new Font("Helvetica", Font.BOLD, 50);
        mainFrame = new JFrame("Oberu");
        //mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(1000, 1000);
        mainFrame.setLayout(new GridLayout(3, 3));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JLabel("", JLabel.CENTER);
        header.setFont(helvetica);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(header);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        event();
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

    public void event(){
        /**
         * The event method is the method that allows us to define and consolidate all of the interactive elements within the GUI.
         * This method is creates the Buttons, gives them an action command, defines their listener and then adds them into the
         * JPanel that we created earlier.
         */
        header.setText("Oberu");

        JButton studyButton = new JButton("Study");
        JButton createDeckButton = new JButton("Create Deck");
        JButton exitButton = new JButton("Exit");

        studyButton.setActionCommand("Study");
        createDeckButton.setActionCommand("Create Deck");
        exitButton.setActionCommand("Exit");

        studyButton.addActionListener(new ButtonClickerListener());
        createDeckButton.addActionListener(new ButtonClickerListener());
        exitButton.addActionListener(new ButtonClickerListener());

        controlPanel.add(studyButton);
        controlPanel.add(createDeckButton);
        controlPanel.add(exitButton);
    }
    private class ButtonClickerListener implements ActionListener{
        /**
         * This class is the Action Listener for the Buttons created the event() method.
         * It's what gives functionality to all of the buttons, take for example the Study
         * button is setup to call the fileSelection method so that we can get the directory
         * of the deck of cards in order to display the cards.
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Study")){
                displayCard cardDisplay = new displayCard();
                cardDisplay.prepareGUI();

            }
            if(command.equals("Create Deck")){
               displayDeckCreation deckCreation = new displayDeckCreation();
                deckCreation.prepareGUI();
            }
            else if(command.equals("Exit")){
                System.exit(10);
            }
        }
    }
}
