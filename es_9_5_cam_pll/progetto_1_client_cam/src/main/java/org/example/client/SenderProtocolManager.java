package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: Senderprotocol --> Monta i messaggi da inviare ad un eventuale client
 */
import edu.avo.udplibcom.Sender;

import java.net.InetAddress;

public class SenderProtocolManager {

    Sender sender;
    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
    }

    public void sendRun(InetAddress address, int port) {
        String msg = "add#";
        byte[] bytes = msg.getBytes();
        sender.send(bytes, address, port); //aggiungere variabile per identificare una porta specifica
    }

    //un server viene rimosso dalla visualizzazione delle immagini
    public void sendStop(InetAddress address, int port){
        String msg = "stop#";
        byte[] bytes = msg.getBytes();
        sender.send(bytes,address,port);
    }
}
