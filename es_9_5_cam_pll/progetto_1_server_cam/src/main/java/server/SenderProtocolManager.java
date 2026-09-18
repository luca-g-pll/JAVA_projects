package server;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: SenderProtocolManager --> Monta i messaggi da inviare ad un eventuale client
 */

import edu.avo.udplibcom.Sender;

import java.net.InetAddress;

public class SenderProtocolManager {

    Sender sender;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
    }

    public void sendUpdate(byte[] imgData, InetAddress address, int port) {
        //porta presa in automatico tramite il Receiver, assieme all'ip del mittente
        //volendo la si può modificare se il client utilizza un porta di default e non si vuole che il server la cerchi
        sender.send(imgData, address, port);
        //System.out.println("\ndati inviati all'ip : "+address);
    }

}
