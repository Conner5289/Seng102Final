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

    public saveTextWindow(){
        setVisible(true);
        setSize(250,75);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(savePanel);

        saveFile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String fileName = fileNameTxtArea.getText();//Gets text in text area
                File newFile = new File(fileName);

                try {
                    newFile.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);//makes new file from user input
                }
                FileWriter fileInput = new FileWriter(fileName);

                fileInput.write(mainGui.getText());
                fileInput.close();
                dispose();//closes save window

            }
        });
    }
}