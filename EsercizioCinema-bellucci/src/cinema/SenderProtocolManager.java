/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import cinema.persistence.Seat;
import io.Sender;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MULTI01
 */
public class SenderProtocolManager {

    private final Sender sender;
    private final Map<Integer, String> messages;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
        messages = new HashMap<>();
        messages.put(1, "BookinOk");
        messages.put(2, "UnavailableSeats");
        messages.put(3, "SoldOut");
    }

    public void sendInformation(List<String> rooms, List<String> hours) {
        String message = "Information*";
        for (String room : rooms) {
            message += room + "#";
        }
        message = message.substring(0, message.length() - 1);
        message += "$";
        for (String hour : hours) {
            message += hour + "#";
        }
        message = message.substring(0, message.length() - 1);
        sender.send(message);
    }

    public void sendAvalaibleSeats(String room, String hour, String day, List<Seat> seats) {
        String message = "AvailableSeats*" + room + "$" + hour + "$" + day + "$";
        for (Seat seat : seats) {
            message += seat.getNumber() + "#";
        }
        message = message.substring(0, message.length() - 1);
        sender.send(message);
    }

    public void sendStatus(int status) {
        String message = "Status*" + messages.get(status);
        sender.send(message);
    }

    public void sendError(String code) {
        String message = "Error*" + code;
        sender.send(message);
    }

    public void close() {
        sender.send("Quit");
        sender.close();
    }

}
