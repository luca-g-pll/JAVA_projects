package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: Inputframe --> Classe che crea un frame di inserimento per il collegamento ai server tramite port-IP
 *        e per ogni aggiunta crea un frame  posizionato sullo schermo, per ogni collegamento con il server, quindi per
 *        ogni collegamento, il bottone crea un receiver/sender/view apposito per il singolo server
 */
import edu.avo.udplibcom.IDataConsumer;
import edu.avo.udplibcom.Receiver;
import edu.avo.udplibcom.Sender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class InputFrame extends JFrame {
    private JTextField ipAddressField;
    private JTextField portField;
    public int xFrames;
    public int yFrames;
    private JButton connectButton;

    public InputFrame() {

        xFrames = 10;
        yFrames = 10;

        initComponents();
        setupUI();

        setLocation(1100, 350);
        setSize(300, 150);
        setVisible(true);
    }

    //metodo che contiene le impostazioni di base del Frame
    private void initComponents() {
        setTitle("IP and Port Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ipAddressField = new JTextField(15);
        portField = new JTextField(6);

        connectButton = new JButton("Connetti server");

        this.setConnetionButton(connectButton);
    }

    //organizza i componenti all'interno del frame utilizzando un layout a griglia
    //e li aggiunge al pannello, che a sua volta viene aggiunto al frame
    private void setupUI() {
        //Gridbaglayout() : consente di posizionare  i componenti in un a griglia di celle
        JPanel panel = new JPanel(new GridBagLayout());
        //specifica come i componenti devono essere posizionati  della griglia del layout
        GridBagConstraints gbc = new GridBagConstraints();
        //impostato un margine di 5 px su tutti i lati di ogni compnente
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel ipLabel = new JLabel("IP:");
        //riga e colonna di dove deve essere posizionato il componente nella griglia tramite il gridBagContraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        //aggiunto al panel il componente con le sue impostazioni di posizionamento
        panel.add(ipLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(ipAddressField, gbc);

        JLabel portLabel = new JLabel("Port:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(portLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(portField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(connectButton, gbc);

        add(panel);
    }

    //contiene l'actionListener del bottone per la connessione ai server
    private void setConnetionButton(JButton b){

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InetAddress indirizzoIP = InetAddress.getByName( ipAddressField.getText());
                    int port = Integer.parseInt(portField.getText());

                    if(port <= 0 || port > 65535){
                        //Controllo sull'inserimento di una porta esistente
                        JOptionPane.showMessageDialog(InputFrame.this,
                                "Inserisci una porta valida (1-65535)!",
                                "Errore di porta", JOptionPane.ERROR_MESSAGE);
                    }else{

                        DatagramSocket socket = new DatagramSocket();
                        Sender sender = new Sender(socket);

                        SenderProtocolManager spm = new SenderProtocolManager(sender);
                        ICommandConsumer view = new View(spm, xFrames, yFrames);

                        //spostato il Frame verso dx
                        xFrames += 160;


                        IDataConsumer dataCons = new ReceiverProtocolManager(view);

                        Receiver r = new Receiver(socket, 65500);
                        r.setConsumer(dataCons);

                        //invio dati al server
                        spm.sendRun(indirizzoIP,port);

                    }
                    //controlli inerenti alla porta/creazione socket/numeri non corretti per le porte/IP
                } catch (UnknownHostException errorIP) {
                    JOptionPane.showMessageDialog(InputFrame.this, "Indirizzo IP non disponibile!",
                            "Errore di IP", JOptionPane.ERROR_MESSAGE);
                } catch (SocketException ex) {
                    JOptionPane.showMessageDialog(InputFrame.this, "Errore durante la creazione del socket!",
                            "Errore di socket", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(InputFrame.this, "Inserisci una porta valida!",
                            "Errore di porta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
