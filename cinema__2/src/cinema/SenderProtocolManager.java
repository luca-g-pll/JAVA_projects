/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;
import cinema.persistence.Seat;
import io.Sender;

import java.util.List;

/**
 *
 * @author MULTI01
 */
public class SenderProtocolManager {

    private Sender sender;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
    }

    public void sendInfo(List<String> rooms, List<String> hours){
        String message = "Seats%";

        //stampa lista room
        for (String room : rooms) {
            message += room + "#";
        }
        //stampa lista hours - con altro tipo di for - si potrebbe fare lo stesso di rooms ma con hours
        for (int i = 0; i < hours.size(); i++) {
            message += hours.get(i) + "#";
        }
        message = message.substring(0, message.length() - 1);
        sender.send(message);
    }


    public void sendFreeSteas(String room, String hour, String day,List<Seat> posti){

        String message = "AvailableSeats*" + room + "$" + hour + "$" + day + "$";

        for(int i = 0; i < posti.size(); i++) { // = Seat seat : seats
            message += posti.get(i).getNumber() + "#"; // =  message += seat.getNumber() + "#";
        }
        message=message.substring(0,message.length()-1);// ----> per togliere l'ultimo '#'

        sender.send(message);



        //mandare lista
    }


    public void sendError(String message){
        sender.send("Error#"+message);
    }

//si potevano usae le hashmap per lo status come ha fatto il prof
    public void sendStatusSteas(String s){
        sender.send("status*" + s);
    }

    public void close(){
        sender.send("Quit*Quit");
        sender.close();
    }

}
