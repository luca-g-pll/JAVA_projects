/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.persistence;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MULTI01
 */
public class DbSimulation implements IPersistence {

    Map<String, Map<String, List<Room>>> db;
    String[] hours = {"17:30", "20:00", "22:30"};

    public DbSimulation() {

        db = new HashMap<>();
        LocalDate now = LocalDate.now();
        LocalDate current = LocalDate.now();
        for (; current.isBefore(now.plus(7, ChronoUnit.DAYS)); current = current.plus(1, ChronoUnit.DAYS)) {
            Map<String, List<Room>> mapHours = new HashMap<>();
            for (int j = 0; j < 3; j++) {

                List<Room> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add(new Room("Sala" + (i + 1), 10));
                }
                mapHours.put(hours[j], list);

            }
            db.put(current.toString(), mapHours);
        }
    }

    @Override
    public boolean booking(String room, String hour, String day, String[] seats) {
        boolean ok = false;
        int index = db.get(day).get(hour).indexOf(new Room(room));
        if (index >= 0) {
            Room searchedRoom = db.get(day).get(hour).get(index);
            ok = searchedRoom.booking(seats);
        }
        return ok;
    }

    @Override
    public List<Seat> selectFreeSeats(String room, String hour, String day) {
        List<Seat> list = null;
        int index = db.get(day).get(hour).indexOf(new Room(room));
        if (index >= 0) {
            Room searchedRoom = db.get(day).get(hour).get(index);
            list = searchedRoom.getAvalaibleSeat();
        }
        return list;
    }

    public List<String> selectRooms() {
        LocalDate tomorrow = LocalDate.now().plus(1, ChronoUnit.DAYS);
        List<Room> rooms = db.get(tomorrow.toString()).get("17:30");
        List<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.add(room.getName());
        }
        return names;
    }

    public List<String> selectHours() {
        List<String> hours = new ArrayList<>();
        for (String hour : this.hours) {
            hours.add(hour);
        }
        return hours;
    }
}
