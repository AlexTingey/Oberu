import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alex
 * Created by Alex on 3/22/2016.
 *
 * This class is what displays the deck creation menu.
 */
public class displayDeckCreation {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JLabel title;
    /**
     * Here we declare our JFrame, JPanel, and the title for the deck creation menu.
     */

    public void prepareGUI(){
        /**
         * This is where we establish all of the non-interactive elements of the GUI, so the title will be fleshed out here
         * as well as the JPanel.
         */
        Font helvetica = new Font("Helvetica", Font.BOLD, 50);
        //have to keep consistency with Fonts.
        mainFrame = new JFrame("Create Card");
        mainFrame.setSize(500, 500);
        mainFrame.setLayout(new GridLayout(2, 3));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        title = new JLabel("Create a Card", JLabel.CENTER);
        title.setFont(helvetica);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(title);
        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);

        event();
    }
    public void event(){
        /**
         * Here we flesh out the interactive elements of our program. This is where our button(s) and our JTextFields are declared
         * and put to use.
         */
        JButton create = new JButton("Create");
        //JButton cancel = new JButton("Cancel");

        JTextField header = new JTextField("Header", 10);
        JTextField footer = new JTextField("Footer", 10);
        JTextField body = new JTextField("Body", 5);

        create.setActionCommand("Create");
        //cancel.setActionCommand("Cancel");

        create.addActionListener(new ButtonClickerListener());
        //cancel.addActionListener(new ButtonClickerListener());

        controlPanel.add(header);
        controlPanel.add(footer);
        controlPanel.add(body);
        controlPanel.add(create);
       // controlPanel.add(cancel);
    }
    private class ButtonClickerListener implements ActionListener{
        /**
         * This class gives the buttons functionality.
         * @param e
         */
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Create")){
                //todo it creates the card
                System.out.println("Will one day create a card");
            }
            /*else if(command.equals("Cancel")){
                System.exit(10);
            }*/
        }
    }
}
