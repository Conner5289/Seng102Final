import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class saveTextWindow extends JFrame{
    private JTextField fileNameTxtArea;
    private JPanel savePanel;
    private JButton saveFile;
    private JLabel notGoodName;


    public saveTextWindow(String userTxt){
        setVisible(true);
        setSize(250,75);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(savePanel);
        setTitle("Save");
        notGoodName.setVisible(false);
        setResizable(false);
        setLocation(750, 250);


        saveFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                Pattern regexPat = Pattern.compile("(^\\w+\\.txt$)");
                boolean regex;
                String fileName;
                int i = 0;

                fileName = fileNameTxtArea.getText() + ".txt";//Gets text in text area
                Matcher regexMatcher = regexPat.matcher(fileName);
                regex = regexMatcher.matches();
                while (!regex){

                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"That is not a usable filename");
                    fileNameTxtArea.setText(null);
                    setVisible(true);
                    fileName = fileNameTxtArea.getText();
                    Scanner srcn = new Scanner(fileName);
                    fileName= srcn.nextLine();
                    regexMatcher = regexPat.matcher(fileName);
                    regex = regexMatcher.matches();

                }
                System.out.println(i);
                i++;

                //makes are writes file to the name that the user made
                try {
                    FileWriter fileInput = new FileWriter(fileName);
                    fileInput.write(userTxt);
                    fileInput.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                dispose();//closes save window
            }
        });
    }
}
