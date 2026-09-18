/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema;

import cinema.persistence.IPersistence;
import cinema.persistence.SimulPersistence;
import io.IMessageConsumer;
import io.Reader;
import io.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MULTI01
 */
public class Cinema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(60000);
        while (true) {
            Socket s = ss.accept();

            PrintWriter out = new PrintWriter(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            Sender sender = new Sender(out);
            SenderProtocolManager senderProtocol = new SenderProtocolManager(sender);

            IPersistence sm = new SimulPersistence(); //database

            Application app = new Application(senderProtocol,sm);
            IMessageConsumer receiver = new ReceiverProtocolManmager(app);

            Reader reader = new Reader(in, "Quit");
            reader.setConsumer(receiver);

            app.information();//per mandare le information all'inizio della comunicazione

        }
    }
    
}
