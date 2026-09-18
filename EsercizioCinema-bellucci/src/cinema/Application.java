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
public class Application implements ICommandConsumer {

    private final SenderProtocolManager sender;
    private final IPersistence db;

    public Application(SenderProtocolManager sender, IPersistence db) {
        this.sender = sender;
        this.db = db;
    }

    @Override
    public void information() {
        List<String> roomNames = db.selectRooms();
        List<String> hours = db.selectHours();
        sender.sendInformation(roomNames, hours);
    }

    @Override
    public void availableSeats(String room, String hour, String day) {
        List<Seat> availables = db.selectFreeSeats(room, hour, day);
        if (availables.isEmpty()) {
            sender.sendStatus(3);
        } else {
            sender.sendAvalaibleSeats(room, hour, day, availables);
        }

    }

    @Override
    public void booking(String room, String hour, String day, String[] seats) {
        if (db.booking(room, hour, day, seats)) {
            sender.sendStatus(1);
        } else {
            sender.sendStatus(2);
        }
    }

    @Override
    public void error(String code) {
        sender.sendError(code);
    }

    @Override
    public void close() {
        sender.close();
    }

}
