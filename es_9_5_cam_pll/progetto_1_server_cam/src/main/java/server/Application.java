package server;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: Application --> Applicazione effettiva su cui avviene l'acquisizione delle immagini sul sistema
 */
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;

public class Application implements ICommandConsumer{

    private SenderProtocolManager sender;

    FrameGrabber grabber = new OpenCVFrameGrabber(0);
    private boolean running = false; //booleano utile per gestire il run del thread e il suo stop

    public Application(SenderProtocolManager sender){
        this.sender = sender;
    }

    @Override
    public void capture(InetAddress address, int port) {

        //acquisisce frame da una sorgente video --> con idx '0' identifica la fotocamera predefinita di sistema
        //creato ma sopra il thread GRABBER per prendere i frame dal flusso di immagini


        //creata img vuota grandezza dell'immagine che viene presa 150x150
        //BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
        // --> utile nel client per visualizzare a video le img

        try {
            //startato il metodo per acquisire le immagini (thread)
            grabber.start();
            running = true;
        } catch (FrameGrabber.Exception e) {
            throw new RuntimeException(e);
        }
        //ciclo di acquisizione immagini, eseguito finche 'runninng' == true
        while (running) {
            //convertiti frame in oggetti BufferedImage
            Java2DFrameConverter paintConverter = new Java2DFrameConverter();
            try {
                //tramtie grabber.grab viene prelevato un frame dalla sorgente di acquisizione
                //della fotocamera e convertito in bufferedImage
                BufferedImage bi = paintConverter.getBufferedImage(grabber.grab());
                //creato un nuovo bufferedImage delle dimensione volute del frame e del tipo indicato
                //con un massimo di 200 lo si puo inviare senza troppi problemi
                BufferedImage im = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

                //obj Graphics, nel quale viene creata l'img scalata 150x150 (dim. volute)
                Graphics g = im.createGraphics();
                //metodo usato per migliorare la qualità dei px nel formato rgb
                //con un massimo di 200 lo si puo inviare senza troppi problemi
                g.drawImage(bi.getScaledInstance(150, 150, Image.SCALE_SMOOTH), 0, 0, null);
                //libera le risosrse ed in questo caso la fotocamera di sistema e deallocalo le risorse che la usano
                g.dispose();

                //creato un byteArray che si incrementa all'aggiungersi di data
                ByteArrayOutputStream bufferByteArrayIgm = new ByteArrayOutputStream();

                //presa img rappresentata come obj buffereImage e scritta in flusso di byte come file file PNG
                ImageIO.write(im, "png", bufferByteArrayIgm);//CONVERTITO im in formato PNG e scritto su un flusso di byte

                //flusso di byte di immagine salvata in un array di byte
                byte[] imgBytes = bufferByteArrayIgm.toByteArray();

                //se da problem potrebbe essere meglio usare ByteArrayInputStream al posto di un Byte[] utile
                //per poi visuallizare i dati in modo più semplice come fosse un flusso di dati

                //metodo che invia il frame al client
                sender.sendUpdate(imgBytes, address, port);

                //System.out.println("ho acquisito un frame ");
            } catch (Exception e) {
                System.out.println("Problemi nell'acquisire il frame :(");
            }
        }
    }

    //metodo non utilizzabile dal client poiche il server rimane attivo nell'acquisizione di immagini, disponibili
    //per altri client che vogliono connettersi
    @Override
    public void stopCapture() {

        //il client smette di guardare solo non andrà a stoppare il server quando smetterà di guardarlo

        //metodo vuoto che
            try {
                grabber.stop();
                running = false;
            } catch (FrameGrabber.Exception e) {
                throw new RuntimeException(e);
            }

    }
}
