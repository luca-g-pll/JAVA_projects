/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import librerie.IDataConsumer;
import librerie.Receiver;
import librerie.Sender;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author palma
 */
public class Main {

    public static void main(String[] args) throws SocketException {

        DatagramSocket socket = new DatagramSocket(60000);
        Receiver r = new Receiver(socket, 65500);

        Sender sender = new Sender(socket);
        SenderProtocolManager spm = new SenderProtocolManager(sender);
        IApplicationObserver obs = new Application(spm);
        IDataConsumer dataCons = new ServerConsumer(obs);
        r.setConsumer(dataCons);

    }

}
