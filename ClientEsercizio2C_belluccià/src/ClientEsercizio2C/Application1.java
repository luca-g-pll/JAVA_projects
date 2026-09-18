package ClientEsercizio2C;


import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MULTI01
 */
public class Application1 extends JFrame implements ICommandConsumer {

    private JTextField text;
    private JComboBox<String> commands;
    private SenderProtocolManager sender;
    private JLabel label;

    public Application1(SenderProtocolManager sender) {
        this.sender = sender;
        String [] array={"Maiuscolo","Minuscolo","Inversione",
            "EliminaSpazi","EliminaVocali","EliminaConsonanti"};


        text=new JTextField(10);
        commands=new JComboBox<>(array);
        JButton button=new JButton("invia");

        button.addActionListener((e) -> {
            sender.send((String)commands.getSelectedItem(), text.getText());
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                sender.close("Quit");                  
            }
        });

        label=new JLabel("          ");

        setLayout(new GridLayout(2,2,2,2));
        add(text);
        add(commands);
        add(button);
        add(label);        
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        sender.send(" ","");
    }
    
    
    
    @Override
    public void visualize(String cmd, String string) {
        label.setText(string);
    }


}
