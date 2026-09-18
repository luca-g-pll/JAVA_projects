package pack_banca;
/*
 * Pillitu Luca
 * SenderProcolManager - classe per l'invio del risulato in stringa dall'elabolazione dei dati nell'application
 *
 */

import io.Sender;
import persistenza.Movimento;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SenderProtocolManager {
    private final Sender sender;
    private final Map<Integer,String> errorMessages;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
        errorMessages = new HashMap<>();
        errorMessages.put(1, "unknown command");
        errorMessages.put(2, "missing parameters");
        errorMessages.put(3, "wrong number format");
        errorMessages.put(4, "wrong date format" );
        errorMessages.put(5, "invalid negative numbers OR zero can not be insert");
        errorMessages.put(6, "internal library error OR missing login");
        errorMessages.put(7, "invalid credentials");
        errorMessages.put(8, "invalid IBAN");
    }

    public void sendLogin(boolean loginOk){
        String msg ="fallito";

        if(loginOk){
            msg="accettato";
        }
        sender.send("\nlogin#"+msg+"\n");
    }

    public void sendSaldo(double saldo){
        sender.send("\ngetSaldo#attuale = "+ saldo+"\n");
    }

    public void sendEstratto(List<Movimento> mov,double saldo){
        String msg = "\ngetEstratto = ";
        String type = " -";
        for (Movimento m: mov) {
            msg += m.getData() + " ^ ";//m.toString();
            if(m.isVersamento()){
                type = " +";
            }
            msg +=  type + m.getImporto() + " ? ";
        }
        msg = msg.substring(0,msg.length()-1);
        msg += " --> il saldo attuale = " + saldo+"\n";
        sender.send(msg);
    }

    public void sendVersamento(String importo) {
            String msg = "\ndoVersamento#"+importo+" = fatto\n";
        sender.send(msg);
    }

    public void sendPrelievo(String importo){
            String msg = "\ndoPrelievo#"+importo+" = fatto\n";
        sender.send(msg);
    }

    public void sendBonifico(String datiBonifico){
        String msg = "\nbonifico#"+datiBonifico+" = fatto \n";
        sender.send(msg);
    }

    public void sendSearchMovimenti(List<Movimento> mov,String data1,String data2){
        String msg = "\nsearchMovimento#"+data1+"%"+data2+" = ";
        String type = " -";
        for (Movimento m: mov) {
            msg += m.getData() + " ^ ";//m.toString();
            if(m.isVersamento()){
                type = " +";
            }
            msg +=  type + m.getImporto() + " ? ";
        }
        msg = msg.substring(0,msg.length()-1);
        sender.send(msg+"\n");
    }

    public void sendError(int value){
        sender.send("\nError "+errorMessages.get(value)+"\n");
    }

    public void sendClose(){ sender.close(); }
}
