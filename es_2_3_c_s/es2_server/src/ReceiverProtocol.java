import io.IMessageConsumer;
public class ReceiverProtocol implements IMessageConsumer{

    ICommandConsumer comandConsumer; //istanza dell'interfaccia implementata dall'Application

    public ReceiverProtocol(ICommandConsumer command){ comandConsumer= command;    }
    @Override
    public void consumeMessage(String message) {

        //tramite split spezzo la stringa in questo caso in due pezzi , uno prima della stringa ## e uno dopo

        if (!message.equals("quit")) {

            String[] splitString=message.split("##");

            //all'interno della prima stringa c'è il cmd, il quale copiamo esattamente per applicarlo, richiamandolo tramite nome
            switch (splitString[0]) {
                case "maiuscolo":
                    comandConsumer.maiuscolo(splitString[1]);
                    break;
                case "minuscolo":
                    comandConsumer.minuscolo(splitString[1]);
                    break;
                case "inversione":
                    comandConsumer.inversione(splitString[1]);
                    break;
                case "eliminaSpazi":
                    comandConsumer.eliminaSpazi(splitString[1]);
                    break;
                case "eliminaVocali":
                    comandConsumer.eliminaVocali(splitString[1]);
                    break;
                case "eliminaConsonanti":
                    comandConsumer.eliminaConsonanti(splitString[1]);
                    break; //arresto forzato del codice dello switch
            }
        }else{
            comandConsumer.close();
            System.out.println("connessione terminata - server chiude connessione con client");
        }
    }
}
