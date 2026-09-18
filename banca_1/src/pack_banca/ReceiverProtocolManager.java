package pack_banca;
/*
 * Pillitu Luca
 * ReceiverProtocolManager - classe per la ricezioend ei comandi e la traduzione in stringa
 *
 */

import io.IMessageConsumer;


public class ReceiverProtocolManager implements IMessageConsumer {

    ICommandConsumer consumer;

    public ReceiverProtocolManager(ICommandConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void consumeMessage(String s) {

        String[] cmd = s.split("#");//nello schema di progettazione è descritto come '*'
        String command = cmd[0];
        String[] parametri = null;

        if (cmd.length > 1) {
            parametri = cmd[1].split("%");//nello schema di progettazione è descritto come '$'
        }
            //stampo per controllo il tipo di comando su quale lavora lo switch
            System.out.println(command);
            switch (command) {
                case "login": {
                    if (parametri != null && parametri.length != 2 ) {//controllo dell'errore
                        consumer.error(2);
                    }else{
                        consumer.login(parametri[0],parametri[1]);
                    }

                    break;
                }
                case "getSaldo": {
                        consumer.getSaldo();
                    break;
                }

                case "getEstratto": {
                    if (parametri != null && parametri.length != 1 ) {//controllo dell'errore
                        consumer.error(2);
                    }else{
                        consumer.getEstratto(parametri[0]);
                    }
                    break;
                }

                case "doVersamento": {
                    if (parametri != null && parametri.length != 1 ) {//controllo dell'errore
                        consumer.error(2);
                    }else{
                        consumer.doVersamento(parametri[0]);
                    }

                    break;
                }

                case "doPrelievo": {
                    if (parametri != null && parametri.length != 1 ) {//controllo dell'errore
                        consumer.error(2);
                    }else{
                        consumer.doPrelievo(parametri[0]);
                    }

                    break;
                }

                case "bonifico": {
                    if (parametri != null && parametri.length != 2 ) {
                        consumer.error(2);
                     }else{
                        consumer.bonifico(parametri[0],parametri[1]);
                    }

                    break;
                }

                case "searchMovimento": {
                    if (parametri != null && parametri.length != 2 ) {
                        consumer.error(2);
                    }else{
                        consumer.searchMovimento(parametri[0],parametri[1]);
                    }

                    break;
                }

                case "Quit": {
                        this.close();
                    break;
                }
                default: {
                    consumer.error(1);
                }
            }
    }

    public void close() {  consumer.close(); }

}
