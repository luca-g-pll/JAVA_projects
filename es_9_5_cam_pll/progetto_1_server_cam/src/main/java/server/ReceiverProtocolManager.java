package server;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: ReceiverProtocolManager --> Legge i messaggi ricevuti nel Receiver e li traduce per mandarli all'app
 */

import edu.avo.udplibcom.IDataConsumer;

import java.net.InetAddress;

public class ReceiverProtocolManager implements IDataConsumer {

    ICommandConsumer consumer;

    public ReceiverProtocolManager(ICommandConsumer consumer){
        this.consumer = consumer;
    }

    //bytes = data ricevuti
    //i = datalenght del messaggio
    //inetAddress = indirizzo ip da cui si ha ricevuto il messaggio
    //i1 = porta da cui il mittente ha mandato il messaggio

    @Override
    public void consumeData(byte[] bytes, int i, InetAddress inetAddress, int i1) {

        //tradotto l'intero array di byte in una string dove sarà presente il comando
        String msg = new String(bytes);

        String[] command = msg.split("#");
        System.out.println(command[0]);
        switch (command[0]) {
            case "add" -> { //il client richiede le immagini da un server
                consumer.capture(inetAddress, i1);
            }
            case "stop" -> {
                System.out.println("Il client precedente ha smesso di utilizzare la fotocamera");
                //consumer.stopCapture();
            }
        }
    }
}