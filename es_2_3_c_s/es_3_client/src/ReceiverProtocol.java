import io.IMessageConsumer;

public class ReceiverProtocol implements IMessageConsumer{


    ICommandConsumer comandConsumer; //istanza dell'interfaccia implementata dall'Application

    public ReceiverProtocol(ICommandConsumer command){
        comandConsumer= command;
    }

    @Override
    public void consumeMessage(String message) { //questo metodo viene richiamato dentro a reader per richiamare la stringa letta dalla comunnicazione col socket

        if(message.equals("quit")){
            comandConsumer.close();
        }else{
            String[] splitMessage = message.split("##");
            comandConsumer.show(splitMessage[0], splitMessage[1]);
        }

    }
}
