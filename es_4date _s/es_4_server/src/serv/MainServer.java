package serv;

import io.IMessageConsumer;
import io.Reader;
import io.Sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {


//        Per le date fare riferimento a LocalDate

            ServerSocket ss = null;
        //while(true) {
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
            ICommandConsumer app = new AppicationDate(sp);
            //definisco un oggetto tramite la sua interfaccia
            IMessageConsumer rc= new ReceiverProtocol(app);

            reader.setConsumer(rc);
        //}
    }
}