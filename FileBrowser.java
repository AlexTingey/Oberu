import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by 9485974 on 3/18/2016.
 */
public class FileBrowser extends JPanel{
    JButton save, open;
    JTextArea log;
    JFileChooser pickDirectory;
    public FileBrowser(){
        super(new FlowLayout());
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        pickDirectory = new JFileChooser();
        pickDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        open = new JButton("Open");
        open.addActionListener(this);
        save = new JButton("Save");
        save.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(open);
        buttonPanel.add(save);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == open){
            int ret = pickDirectory.showOpenDialog(FileBrowser.this);
            if(ret == JFileChooser.APPROVE_OPTION){
                File file = pickDirectory.getSelectedFile();
                String location = file.getAbsolutePath();
                log.append("Do you want to open: " + location);
            }
            else{
                log.append("Open Cancelled");
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
        else if(e.getSource() == save){
            int ret = pickDirectory.showSaveDialog(FileBrowser.this);
            if(ret == JFileChooser.APPROVE_OPTION){
                File file = pickDirectory.getSelectedFile();
                //todo make the program actually save
                log.append("this will save in the future");
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }
    public static void showIt(){
        JFrame frame = new JFrame("Select File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new FileBrowser());

        frame.pack();
        frame.setVisible(true);
    }

}
