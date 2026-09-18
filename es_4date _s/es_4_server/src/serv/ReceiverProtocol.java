package serv;

import io.IMessageConsumer;

public class ReceiverProtocol implements IMessageConsumer {

    ICommandConsumer consumer;

    SenderProtocol senderError;

    public ReceiverProtocol(ICommandConsumer c){
        this.consumer = c;
    }

    @Override
    public void consumeMessage(String msg) {
            String[] splitMsg=msg.split("#");
            //controllo errore

        switch (splitMsg[0]) {

            case "diffFromNow" :
                consumer.diffFromNow(splitMsg[1]);
                break;
            case "diffDates" :
                consumer.diffDates(splitMsg[1]);
                break;
            case "dayOfWeek" :
                consumer.daysOfWeek(splitMsg[1]);
                break;
            case "quit" :
                consumer.close();
                System.out.println("connessione terminata - server chiude connessione con client");
                break;
            default://per errore d inserimento comando
                senderError.buildErrorCmd(msg); //il comando è scritto in modo errato --> non riconosciuto
                break;

        }

    }










}
