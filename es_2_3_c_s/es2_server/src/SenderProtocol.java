import io.Sender;
public class SenderProtocol implements ISenderProtocol{
    Sender sender;

    public SenderProtocol(Sender s) { sender = s; }

    //metodo per l'assemblamento del messaggio da usare come risposta
    @Override
    public void buildMessage(String cmd, String convert) {
        String message= cmd + "##" + convert;
        sender.send(message); //qua mando a video la risposta
    }
    @Override
    public void close(String string) {
        sender.send(string);
        sender.close();
    }



}
