import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class saveTextWindow extends JFrame{
    private JTextField fileNameTxtArea;
    private JPanel savePanel;
    private JButton saveFile;


    public saveTextWindow(String userTxt){
        setVisible(true);
        setSize(250,75);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(savePanel);
        setTitle("Save");

        saveFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String fileName = fileNameTxtArea.getText();//Gets text in text area

                //makes are writes file to the name that the user made
                //TODO make the file auto append .txt
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
