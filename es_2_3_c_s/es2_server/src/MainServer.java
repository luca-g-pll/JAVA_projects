import io.IMessageConsumer;
import io.Sender;
import io.Reader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = null;
        ss = new ServerSocket(60000);
        Socket s = ss.accept();



        PrintWriter out = new PrintWriter(
                ((Socket) s).getOutputStream());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

        Sender sender = new Sender(out);
        Reader reader = new Reader(in, "quit"); //la conversazione si chiude quando mando un "quit"

        SenderProtocol sp = new SenderProtocol(sender);

        //definisco un oggetto tramite la sua interfaccia
        ICommandConsumer app = new Application(sp);
        //definisco un oggetto tramite la sua interfaccia
        IMessageConsumer rc= new ReceiverProtocol(app);

        reader.setConsumer(rc); // setta il protocollo che deve decifrare il msg, starta la "conversazione" di lettura
    }
}