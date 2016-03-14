import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Alex on 11/14/2015.
 */
 public class Display{

    private JFrame mainFrame;
    private JLabel header;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public void prepareGUI() {
        mainFrame = new JFrame("Oberu");
        mainFrame.setSize(500, 650);
        mainFrame.setLayout(new GridLayout(3, 3));

        header = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);

        statusLabel.setSize(350, 100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBackground(Color.blue);

        mainFrame.add(header);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        event();
    }

    public void event(){
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
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("Study")){
                statusLabel.setText("Will take you to the study section");
                controlPanel.setBackground(Color.BLACK);
            }
            if(command.equals("Create Deck")){
                statusLabel.setText("Will take you to create a deck");
                controlPanel.setBackground(Color.RED);
            }
            else if(command.equals("Exit")){
                statusLabel.setText("One day this will exit");
                controlPanel.setBackground(Color.GREEN);
            }
        }
    }
}
