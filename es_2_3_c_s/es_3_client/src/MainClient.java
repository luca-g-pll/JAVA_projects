import io.IMessageConsumer;
import io.Sender;
import io.Reader;

import java.io.*;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) throws IOException {

        //creazione della socket
        Socket s = new Socket("127.0.0.1",60000);

        //metodi per la strittura e lettura da cmd
        PrintWriter out = new PrintWriter(s.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //creazione del sender, e del sender protocol con all'interno instaurato il sender
        Sender sender = new Sender(out);
        SenderProtocol sp = new SenderProtocol(sender);
        //application
        ICommandConsumer app = new ApplicationGrh(sp);
        //receiver, al quale passo il tipo di application che sto usando
        IMessageConsumer mc = new ReceiverProtocol(app);
        //reader, legge il msg e il msg per la chiusura
        Reader reader = new Reader(in, "quit"); //la conversazione si chiude quando mando un "quit"
        //tramite set consumer, vado a leggere la stringa che arriva tramite la socket e la passo all'application
        reader.setConsumer(mc);//?? --> utilizzo un metodo del receiverProt dentro alla libreria reader
        //da qui parte una reazione a catena tra un richiamo di tutti metodi, partendo dal setConsumer e tutti i richimi sottostanti
        //app.inputMenu();

    }
}