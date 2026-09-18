package server;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: Main
 *         //il client invierà al client un messaggio di connessione
 *         //dove il client tramite ip e porta si connette al server
 *         //e il server invia le i immagini in byte
 *
 *
 *         //per inviare al client i pacchetti posso usare una immagine 200x200 da 40000 byte (40kbt)
 *         //il client quando riceve il pacchetto o se riceve tutti i pacchetto
 *         //quando il client sa di aver ricevuto tutti i byte della foto manda un ok per richidere la foto successiva
 *         //la foto può essere compattata in 200x200 o 150x150 e mandata in blocco unico in teoria
 */

import edu.avo.udplibcom.Receiver;
import edu.avo.udplibcom.Sender;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private static int PORT_BASE = 60000;


    public static void main(String[] args) throws SocketException {

            // Incrementa il contatore delle istanze


            //creazione della socket e impostazione della porta sulla quale deve comunicare
            DatagramSocket socket = new DatagramSocket(PORT_BASE);

            Sender sender = new Sender(socket);

            SenderProtocolManager spm = new SenderProtocolManager(sender);

            ICommandConsumer app = new Application(spm);
            //con il numero nel receiver indichiamo il numero di byte max che si possono ricevere con un messaggio
            Receiver receiver = new Receiver(socket, 65500);
            ReceiverProtocolManager rpm = new ReceiverProtocolManager(app);
            receiver.setConsumer(rpm);
        }

}