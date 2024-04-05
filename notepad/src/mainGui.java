import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainGui extends  JFrame{
    private JButton saveButton;
    private JButton openButton;
    private JTextArea textArea;
    private JPanel mainPanel;

    saveTextWindow saveWindow;

    public mainGui() {
        setVisible(true);
        setSize(750, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setTitle("Notepad");
        makeListener();
    }


    public void makeListener(){
        //-------Action listener for save button
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                saveWindow = new saveTextWindow(textArea.getText());

            }
        });

        //---------Actions listener fo save button
        openButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                openFileWindow openFile = new openFileWindow();
                dispose();
            }
        });
    }


    public void setText(String text){
        textArea.setText(text);
    }
}
