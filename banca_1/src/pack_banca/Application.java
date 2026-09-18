package pack_banca;
/*
 * Pillitu Luca
 * Application - metodi per implementazione del codice e elaborazione dati comandi
 *
 */

import persistenza.IPersistenza;
import persistenza.Movimento;
import persistenza.PersistenzaDb;
//import date :
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

//usare try-catch per prendere l'errore di inserimetno e aggiunere tutti i controlli di errore
public class Application implements ICommandConsumer{
    private final SenderProtocolManager sender;
    private final IPersistenza sp;

    public Application(SenderProtocolManager sender,String connectionDb){
        this.sender = sender;
        this.sp = new PersistenzaDb(connectionDb);
    }
    //metodo per il comando 'login'
    @Override
    public void login(String username, String password) {
        try {
            boolean loginOk = sp.login(username, password);
            if (!loginOk) {
                error(7);
            }
            sender.sendLogin(loginOk);
        }catch (Exception e){
            error(6);
        }
    }

    //metodo per il comando 'getSaldo'
    @Override
    public void getSaldo() {
            try {
                double saldo = sp.saldo();
                sender.sendSaldo(saldo);
            } catch (Exception e) {
                error(6);
            }
    }

    //metodo per il comando 'getEstratto'
    @Override
    public void getEstratto(String movimenti) {
            List<Movimento> mov;
            try {
                //parse del int valore da inserire nel metodo
                int numMovimenti = Integer.parseInt(movimenti);
                //controllo se il numero è negativo
                if (numMovimenti < 0) {
                    error(5);
                }
                else {
                    mov = sp.estrattoConto(numMovimenti);
                    sender.sendEstratto(mov, sp.saldo());
                }
            } catch (NumberFormatException e) {
                error(3);
            }
    }

    //metodo per il comando 'doVersamento'
    @Override
    public void doVersamento(String importo) {
            try {
                double imp = Double.parseDouble(importo); // Tentativo di parsing
                if (imp > 0) {
                    sp.versamento(imp);
                    sender.sendVersamento(importo);
                } else {
                    error(5); // Aggiungi una gestione per l'importo non positivo
                }
            } catch (NumberFormatException e) {
                error(3);
            }
    }

    //metodo per il comando 'doPrelievo'
    @Override
    public void doPrelievo(String importo) {
        //boolean valoreCorretto = true;
            try {
                double imp = Double.parseDouble(importo); // Tentativo di parsing
                if (imp > 0) {
                    if(sp.prelievo(imp)){
                        sender.sendPrelievo(importo);
                    }else{
                        error(6);
                    }
                } else {
                    error(5); // Aggiungi una gestione per l'importo non positivo
                }
            } catch (NumberFormatException e) {
                error(3);
            }
    }

    //metodo per il comando 'bonifico'
    @Override
    public void bonifico(String importo, String iban) {
            try {
                double imp = Double.parseDouble(importo); // Tentativo di parsingà
                if(imp > 0){
                    if(sp.bonifico(imp, iban)){
                        sender.sendBonifico(importo + " % " + iban);
                    }else{
                        error(8);
                    }
                }else{
                    error(5);
                }
            } catch (NumberFormatException e) {
                error(3);
            } catch (Exception e) {
                error(6);
            }
    }

    //metodo per il comando 'searchMovimento'
    @Override
    public void searchMovimento(String data1, String data2) {
        //controllo date
            if ( this.checkDate(data1) && this.checkDate(data2) && this.dateBefore(data1,data2) ) {
                try {
                    List<Movimento> listMovimenti = sp.ricercaMovimenti(data1, data2);
                    sender.sendSearchMovimenti(listMovimenti, data1, data2);
                } catch (Exception e) {
                    error(6);//nel caso dia errori all'interno del metodo Ipersistenza
                }
            }else{
                error(4);
            }
    }

    //metodo per il controllo della data :
    public boolean checkDate(String data){
        boolean check = true;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            formatter.setLenient(false);
            formatter.parse(data);
        } catch (ParseException e) {
            check = false;
        }
        return check;
    }

    //metodo di controllo se una data è prima di un'altra
    public boolean dateBefore(String dataPrecedente, String dataSuccessiva) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        boolean check = false;
        try {
            Date date1 = sdf.parse(dataPrecedente);
            Date date2 = sdf.parse(dataSuccessiva);
            if (date1.before(date2)) {
                check = true;
            }
        } catch (ParseException e) {
            error(4);
        }
        return check;
    }

    @Override
    public void error(int code) {
        sender.sendError(code);
    }

    @Override
    public void close() {
        sender.sendClose();
    }
}