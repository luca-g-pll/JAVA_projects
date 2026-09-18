/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esempiominimale;

import io.IMessageConsumer;
import io.Reader;
import io.Sender;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author palma
 */
public class EsempioMinimale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(60000);
        Map<String, SenderProtocolManager> map = new HashMap<>();
        while (true) {
            Socket s = ss.accept();
            PrintWriter out = new PrintWriter(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            Sender sender = new Sender(out);
            SenderProtocolManager senderProtocol = new SenderProtocolManager(sender);
            Application app = new Application(map, senderProtocol);
            IMessageConsumer receiver = new ReceiverProtocolManager(app);
            Reader reader = new Reader(in, "Logout");
            reader.setConsumer(receiver);
        }
    }

}
