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
    private JButton openButton;
    private JFileChooser fileChooser;
    public String fileLocation = "";
    /**
     * Here we declare our JFrame, JPanel, and the title for the deck creation menu.
     */

    public void prepareGUI(){
        /**
         * This is where we establish all of the non-interactive elements of the GUI, so the title will be fleshed out here
         * as well as the JPanel.
         */
        if(fileLocation.equals("")){
            fileLocation = fileSelect();
        }
        Font helvetica = new Font("Helvetica", Font.BOLD, 35);
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
        mainFrame.setLocationRelativeTo(null);

        event();
    }
    public void event(){
        /**
         * Here we flesh out the interactive elements of our program. This is where our button(s) and our JTextFields are declared
         * and put to use.
         */
        JButton create = new JButton("Create");

       final JTextField header = new JTextField("Header", 10);
       final JTextField footer = new JTextField("Footer", 10);
       final JTextField body = new JTextField("Body", 10);

        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card card = new Card();
                if(body.getText().isEmpty() || body.getText().contains("\\") || body.getText().contains("/")){
                    JOptionPane.showMessageDialog(null, "Illegal argument in body section, please change the input.");
                }
                else{
                    card.saveCard(header.getText(), body.getText(), footer.getText(), fileLocation);
                    mainFrame.setVisible(false);
                    Display display = new Display();
                    display.prepareGUI();
                    System.out.println(fileLocation);
                }
            }
        });

        controlPanel.add(header);
        controlPanel.add(body);
        controlPanel.add(footer);
        controlPanel.add(create);
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
        fileChooser.setDialogTitle("Select Where to save the Card");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(fileChooser.showOpenDialog(openButton) == JFileChooser.APPROVE_OPTION) {
            String deckLocation = fileChooser.getSelectedFile().getAbsolutePath();
            return deckLocation;
        }
        else{
            return fileChooser.getFileSystemView().getDefaultDirectory().toString();

        }

    }

}
