package esempioudpclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class View extends JFrame {

    SenderProtocolManager sender;
    JLabel resultLabel;


    //costruttore
    public View(SenderProtocolManager sender) {
        this.sender = sender;

        JTextField numField1, numField2;

            setTitle("Simple Calculator");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(4, 2));

            // Aggiungi un JComboBox per selezionare l'operatore
            String[] operators = {"+", "-", "*", "/"};
            JComboBox<String> operatorComboBox = new JComboBox<>(operators);
            add(new JLabel("Seleziona un operatore:"));
            add(operatorComboBox);

            // Aggiungi due campi di testo per i numeri
            add(new JLabel("Inserisci il primo numero:"));
            numField1 = new JTextField();
            add(numField1);

            add(new JLabel("Inserisci il secondo numero:"));
            numField2 = new JTextField();
            add(numField2);

            // Aggiungi un pulsante per eseguire il calcolo
            JButton calculateButton = new JButton("Calcola");
            calculateButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    resultLabel.setText("Risultato");
                    int value1 = Integer.parseInt(numField1.getText());
                    int value2 = Integer.parseInt(numField2.getText());
                    try {
                        calculateResult(value1, value2, (String) operatorComboBox.getSelectedItem());
                    } catch (UnknownHostException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            });

            add(calculateButton);

            // Aggiungi una JLabel per visualizzare il risultato
            resultLabel = new JLabel("Risultato qua sotto : ");
            add(resultLabel);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }


        //metodo che calcola 

        private void calculateResult(int value1, int value2, String op) throws UnknownHostException {
        int oper = 0;

            switch (op){
                case "+"-> { oper = 1; }
                case "-"-> { oper = 2; }
                case "*"-> { oper = 3; }
                case "/"-> { oper = 4; }
            }
            sender.sendRequest((byte)oper,(byte)value1,(byte)value2, InetAddress.getByName("127.0.0.1"),60000);
        }

        public void updateResult(int result){
            resultLabel.setText(""+result);
        }
}
