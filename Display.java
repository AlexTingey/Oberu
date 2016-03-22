import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Display {
    private JFrame mainFrame;
    private JLabel header;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JFileChooser fileChooser;
    private JButton openButton;

    public void prepareGUI() {
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
        controlPanel.setBackground(Color.blue);

        mainFrame.add(header);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
        event();
    }
    public String fileSelect(){
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
                System.out.println(fileSelect());
                displayCard cardDisplay = new displayCard();
                cardDisplay.prepareGUI();
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
