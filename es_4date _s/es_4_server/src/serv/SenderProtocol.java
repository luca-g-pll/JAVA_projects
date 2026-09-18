package serv;
import io.Sender;

public class SenderProtocol implements ISenderProtocol{

    Sender sender;

    public SenderProtocol(Sender s){
        sender  = s;
    }


    @Override
    public void buildMessage(String cmd, String date, String result) {
        String message= cmd + "#" + date + " | " + result;
        sender.send(message);

    }

    @Override
    public void buildErrorCmd(String errore) {

        //invia indietro al client un errore di comando con il comando che non ha riconosciuto
        String message= "Error # unknown command"+ " # "+ errore;
        sender.send(message);

    }

    @Override
    public void buildErrorFormat(String errore) {
        //errore di inserimento del formato
        String message= "Error # wrong fromat date"+ " # "+ errore;
        sender.send(message);
    }

    @Override
    public void close(String forClose) {
        sender.send(forClose);
        sender.close();
    }
}
