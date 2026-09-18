package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: ReceiverProtocolManager --> Legge i messaggi ricevuti nel Receiver e li traduce per mandarli alla View
 */
import edu.avo.udplibcom.IDataConsumer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class ReceiverProtocolManager implements IDataConsumer {

    ICommandConsumer consumer;


    //questo valore deve poter essere modificato nel caso venga tolta una cam da quelle presenti e quindi essere decrementato
    public int numCams;


    //mappa che contiene l'ip del server e il numero della cam che sta aggiornando
    Map<InetAddress, Integer> associazioneCam;

    public ReceiverProtocolManager(ICommandConsumer consumer) {
        this.consumer = consumer;
        this.associazioneCam = new HashMap<InetAddress, Integer>();
        this.numCams = 1;
    }

    //bytes = data ricevuti
    //i = datalenght del messaggio
    //inetAddress = indirizzo ip da cui si ha ricevuto il messaggio
    //i1 = porta da cui il mittente ha mandato il messaggio

    //il consumer sarà direttamente la view non all'Application
    @Override
    public void consumeData(byte[] bytes, int i, InetAddress inetAddress, int i1) {

                //controlla che l'ip di chi manda sia gai presente in modo da updatare qualcosa di gia presente o di richiesto
                if(!associazioneCam.containsKey(inetAddress)){
                    //metodo per l'update dell'immagine cercando il frame da aggiornare tramite l'id dell'address
                    try {
                        consumer.updateFrame(associazioneCam.get(inetAddress),bytes);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }else{

                    //aggiunta alla map il server con numero cam sul client
                    associazioneCam.put(inetAddress,this.numCams);
                    //metodo per la creazione della camera e acquisizione dei dati
                    this.numCams ++;
                    try {
                        consumer.addCam(this.numCams, inetAddress, i1, bytes);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
}