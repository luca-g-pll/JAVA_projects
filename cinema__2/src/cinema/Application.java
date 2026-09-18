/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;


import cinema.persistence.IPersistence;
import cinema.persistence.Seat;
import java.util.List;

/**
 *
 * @author MULTI01
 */
public class Application implements ICommandConsumer{

    private SenderProtocolManager sender;
    private IPersistence db;

    public Application(SenderProtocolManager sender, IPersistence db) {
        this.sender = sender;
        this.db = db;
    }

    // metodo che da tutte le informazioni relative alle sale e agli spettacoli disponibili
    @Override
    public void information() {
       //manderà le informazio ad inizio connessione al client
       List<String> sale = db.selectRooms();
       List<String> orari = db.selectHours();
       sender.sendInfo(sale,orari);
    }

    // metodo per ottenere tutti i posti disponibili in una certa sala
    // se una sala è piena e non ha posti liberi, rispondo con sold out
    @Override
    public void availableSeats(String room, String hour, String day) {
       List<Seat> postiLiberi = db.selectFreeSeats(room, hour, day);
       if(postiLiberi.isEmpty()){
           statusSteas("sold out");
       }else{
           sender.sendFreeSteas(room,hour,day,postiLiberi);              //rifare
        }
    }

    // metodo per prenotare uno o piu posti
    @Override
    public void booking(String room, String hour, String day, String[] seats) {

        //stato dei posti se gia prenotati = non disponili se disponibili mando
        boolean notAvailable = db.selectFreeSeats(room, hour, day).isEmpty();
        String m = null;
        if(!notAvailable) {
            if(db.booking(room, hour, day, seats)){
                m="succesfull booking";
            }else{
                m="Seats unvaiable";
            }
        }
        statusSteas(m);
    }

    @Override
    public void error(String code) {
        sender.sendError(code);
    }

    @Override
    public void close() {
     sender.close();
    }

    private void statusSteas(String s){
        sender.sendStatusSteas(s);
    }

}
