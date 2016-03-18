import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Display{

    private JFrame mainFrame;
    private JLabel header;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public void prepareGUI() {
        Font helvetica = new Font("Helvetica", Font.BOLD, 50);
        mainFrame = new JFrame("Oberu");
        mainFrame.setSize(1000, 1000);
        mainFrame.setLayout(new GridLayout(3, 3));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        header = new JLabel("", JLabel.CENTER);
        header.setFont(helvetica);
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
                try{
                    FileBrowser openDeck = new FileBrowser();
                    openDeck.showIt();
                }
                catch(Exception m){
                    System.out.println("Something went really wrong");
                }
                statusLabel.setText("Will take you to the study section");

            }
            if(command.equals("Create Deck")){
                statusLabel.setText("Will take you to create a deck");
                controlPanel.setBackground(Color.RED);
            }
            else if(command.equals("Exit")){
                System.exit(10);
            }
        }
    }
}
