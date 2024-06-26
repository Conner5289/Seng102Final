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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(openPanel);
        setTitle("Open");
        setResizable(false);
        setLocation(750, 250);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtData = null;
                StringBuilder fileData = new StringBuilder();
                String userFile = openTextField.getText();
                //opens and reads the file that the user input
                try {
                    FileInputStream fileIn = new FileInputStream(userFile);
                    Scanner reader = new Scanner(fileIn);
                    while (reader.hasNext()){
                        txtData = reader.nextLine() + "\n";
                        fileData.append(txtData);
                    }
                    mainGui gui = new mainGui();
                    gui.setText(fileData.toString());
                    gui.setVisible(true);
                    System.out.println(fileData.toString());

                    dispose();
                    //brings back the main gui with the files contents
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"That file does not exist");
                }
            }
        });
    }
}
