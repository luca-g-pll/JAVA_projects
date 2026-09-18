import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationGrh extends JFrame implements ICommandConsumer{
    private SenderProtocol senderProtcol;

    private String[] arrayMenu={"maiuscolo","minuscolo","inversione","eliminaSpazi","eliminaVocali","eliminaConsonanti"};

    //variabili per la crazione del frame :
    JTextField text = new JTextField(10);

    JComboBox commands = new JComboBox<>(arrayMenu);

    JButton button = new JButton("Invia");
    JLabel label = new JLabel("              ");

    //metodi
    public ApplicationGrh(SenderProtocol sender){
        this.senderProtcol = sender;

        this.graphiMenu(sender);

    }

    private void graphiMenu(SenderProtocol s){

        button.addActionListener((e)-> {
            s.buildMessage((String)commands.getSelectedItem(),(String)text.getText());
        } );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                s.close("quit");
            }
        });

        this.createframe(s);
    }


    private void createframe(SenderProtocol s){

        setLayout(new GridLayout(2,2,2,2));
        //add al frame:
        add(text);
        add(commands);
        add(commands);
        add(button);
        add(label);
        //impostazioni del frame e dimensione
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//location del frame nello schermo
        setVisible(true);

        //s.buildMessage(" ", " ");//perchè qua lo mette vuoto?
    }

    @Override
    public void show(String command, String string) {
        label.setText(string);
    }

    @Override
    public void close() { senderProtcol.close("quit"); }
}
