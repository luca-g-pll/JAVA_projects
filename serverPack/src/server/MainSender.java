package server;

import io.Sender;
import io.Reader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSender {
    public static void main(String[] args) {

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(60000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Socket s = null;
        try {
            s = ss.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(s.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sender sender = new Sender(out);
        Reader reader = new Reader(in, "quit");

        SenderProtocolManager sp = new SenderProtocolManager(sender);
        App app = new App(sp);

        ReceiverProtocolManager rp = new ReceiverProtocolManager(app);
        reader.setConsumer(rp);

    }
}
