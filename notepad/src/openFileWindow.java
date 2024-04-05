import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class openFileWindow extends JFrame{

    private JTextField openTextField;
    private JPanel openPanel;
    private JButton openButton;


    public openFileWindow(){
        setVisible(true);
        setSize(250, 75);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setContentPane(openPanel);
        setTitle("Open");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtData = null;
                StringBuilder fileData = new StringBuilder();
                String userFile = openTextField.getText();
                try {
                    FileInputStream fileIn = new FileInputStream(userFile);
                    Scanner reader = new Scanner(fileIn);
                    while (reader.hasNext()){
                        txtData = reader.nextLine();
                        fileData.append(txtData);
                    }
                    mainGui gui = new mainGui();
                    gui.setText(String.valueOf(fileData));
                } catch (FileNotFoundException ex) {
                    System.out.println("That file does not exist");
                }
            }
        });
    }
}
