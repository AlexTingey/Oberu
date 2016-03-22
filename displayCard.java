import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 9485974 on 3/22/2016.
 */
public class displayCard {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JLabel header;
    private JLabel body;
    private JLabel footer;
    private Card carl = new Card("","","",0);

    public void prepareGUI(){
        carl.setCardHeader("Mai Nichi");
        carl.setCardBody("??");
        carl.setCardFooter("");
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
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.equals("easy")){
                SRS.demote(carl);
            }
            if(command.equals("ok")){
                carl.setDifficulty(carl.getDifficulty());
            }
            else if(command.equals("difficult")){
                SRS.promote(carl);
            }
        }
    }
}
