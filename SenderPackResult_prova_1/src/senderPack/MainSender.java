package senderPack;

import io.Sender;
import io.Reader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSender {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(60000);
        System.out.println("1");
        Socket s = ss.accept();
        System.out.println("2");
        PrintWriter out = new PrintWriter(s.getOutputStream());
        System.out.println("3");
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("4");
        Sender sender = new Sender(out);
        System.out.println("5");
        Reader reader = new Reader(in, "quit");
        System.out.println("6");

        SenderProtocolManager sp = new SenderProtocolManager(sender);
        System.out.println("7");
        Application app = new Application(sp);
        System.out.println("8");

        ReceiverProtocolManager rp = new ReceiverProtocolManager(app);
        System.out.println("9");
        reader.setConsumer(rp);
        System.out.println("10");

    }
}
