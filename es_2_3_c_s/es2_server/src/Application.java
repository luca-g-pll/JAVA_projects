
public class Application implements ICommandConsumer {

    SenderProtocol senderProtocol;

    public Application(SenderProtocol  sender ){

        senderProtocol=sender;
    }

    //implementazine dei diversi comandi da richiamare
    @Override
    public void maiuscolo(String message) {

        senderProtocol.buildMessage("maiuscolo",message.toUpperCase());
    }

    @Override
    public void minuscolo(String message) {

        senderProtocol.buildMessage("minuscolo",message.toLowerCase());
    }

    @Override
    public void inversione(String message) {
        //stringbuilder = oggetti immutabili, crea una stringa nuova con all'interno un'altra, e modificare la nuova
        StringBuilder sb = new StringBuilder(message); //istanziamento dello string builder
        senderProtocol.buildMessage("inversione",sb.reverse().toString());
    }//istanza anonima, istanziata ma non memorizzata

    @Override
    public void eliminaSpazi(String message) {

        senderProtocol.buildMessage("eliminaSpazi",message.replaceAll(" ",""));
    }

    @Override
    public void eliminaVocali(String message) {
        senderProtocol.buildMessage("eliminaSpazi",message.replaceAll("[aeiouAEIOU]+",""));
    }//espressione regolare
//il + indica il fatto che ne sostituisce più di uno
    @Override
    public void eliminaConsonanti(String message) {
    //replaceAll rimpiazzerà tutti i char inserit nella prima parte, con il char/string inseriti nella seconda parte
        senderProtocol.buildMessage("eliminaSpazi",
                message.replaceAll("[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]",""));
        //message.replaceAll("[^aeiouAEIOU]+","")); --> facevo prima a negare le vocali al posto di dire ogni singola consonante
    }

    @Override
    public void close() {

        senderProtocol.close("quit"); //entrambe le parti dovranno inviarsi il quit
    }


}
