package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: View --> Per ogni collegamento fatto con un server, viene creata una view apposita sulla quale viene
 *        visualizzata l'acquisizione della foto del server
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class View extends JFrame implements  ICommandConsumer{

    SenderProtocolManager sender;

    //mappa contente l'ip del server associato alla label
    JLabel cam;

    //mappa che associa l'ip del server alla sua porta di comunicazione
    Map<InetAddress, Integer> server;

    //dimensioni della finestra
    int x;
    int y;
    BufferedImage bi;


//costruttore della classe View
    public View(SenderProtocolManager spm, int x, int y){

        this.sender = spm;
        this.x=x;
        this.y=y;
        bi=new BufferedImage(150,150,BufferedImage.TYPE_INT_RGB);

        //tramite il metodo sottostante è possibile chiudere il singolo frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.server = new HashMap<>();



        cam=new JLabel(new ImageIcon(bi));
        add(cam);
        setLocation(x,y);
        setTitle("cam");

        pack();
        // Rende la finestra visibile
        setVisible(true);

    }

    @Override
    public void updateFrame(Integer camName, byte[] imgBytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
        BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
        ds = ImageIO.read(bis);
        //aggiunta dell'immagine al frame
        cam.setIcon(new ImageIcon(ds));
        cam.revalidate();
        cam.repaint();
    }

    @Override
    public void addCam(Integer camName, InetAddress address, Integer port, byte[] imgBytes) throws IOException {
          // Aggiunge la telecamera alla mappa
        server.put(address, port);

        ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
        BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
        ds = ImageIO.read(bis);
        //aggiunta dell'immagine al frame
        cam.setIcon(new ImageIcon(ds));
    }


//metodo
    /*
    public void closeCam(){

       addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    // Qui puoi gestire la chiusura della finestra in modo personalizzato
                    // ad esempio, mostrare un messaggio di conferma o salvare dati
                    int choice = JOptionPane.showConfirmDialog(null, "Vuoi davvero chiudere?", "Conferma", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {

                        Set<InetAddress> keys = server.keySet();

                        // Ottenere la prima chiave, se esiste
                        InetAddress firstKey = null;
                        if (!keys.isEmpty()) {
                            firstKey = keys.iterator().next();
                        }

                        sender.sendStop(firstKey,server.get(firstKey));
                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    }
                }
            });
    }
    */

}