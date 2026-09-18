package pack_banca;
/*
 * Pillitu Luca
 * Main - esecuzione codice
 *
 */

import io.IMessageConsumer;
import io.Reader;
import io.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(60000);
        while (true) {
            Socket s = ss.accept();

            PrintWriter out = new PrintWriter(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            Sender sender = new Sender(out);
            SenderProtocolManager senderProtocol = new SenderProtocolManager(sender);

            Application app = new Application(senderProtocol,"jdbc:mysql://localhost:3306/Banca?user=root");
            IMessageConsumer receiver = new ReceiverProtocolManager(app);

            Reader reader = new Reader(in, "Quit");
            reader.setConsumer(receiver);

        }
    }
}