import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel footer;
    private Card carl = new Card("","","",0);
    /**
     *Here we create our JFrame (mainFrame), our JPanel to hold the buttons (controlPanel),
     * and a couple Labels that we will use in order to display information.
     */
    public void prepareGUI(){
        /**
         * Prepare GUI is where we lay out all of the non-interactive elements of the GUI. Things like
         * the card's information are displayed here.
         */
        String cardHeader = new String("Mai Nichi");
        String cardBody = new String("毎日");
        carl.setCardHeader("Every Day");
        carl.setCardBody("毎日");
        carl.setCardFooter("まいにち");
        Font helveticaB = new Font("Helvetica", Font.BOLD, 50);
        Font helveticaM = new Font("Helvetica", Font.BOLD, 25);
        mainFrame = new JFrame("Study");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(4, 3));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JLabel(carl.GetHeader(), JLabel.CENTER);
        header.setFont(helveticaM);

        body = new JLabel(carl.GetBody(), JLabel.CENTER);
        body.setFont(helveticaB);

        footer = new JLabel(carl.GetFooter(), JLabel.CENTER);
        footer.setFont(helveticaM);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(header);
        mainFrame.add(body);
        mainFrame.add(footer);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
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
                SRS.demote(carl);
                System.exit(10);
                //todo bring up next card.
            }
            if(command.equals("ok")){
                carl.setDifficulty(carl.getDifficulty());
                System.exit(10);
                //todo bring up next card
            }
            else if(command.equals("difficult")){
                SRS.promote(carl);
                System.exit(10);
                //todo bring up next card
            }
        }
    }
}
