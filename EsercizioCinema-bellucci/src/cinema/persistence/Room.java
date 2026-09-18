/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author MULTI01
 */
public class Room {

    String name;
    List<Seat> seats;

    public Room(String name, int capacity) {
        seats = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            seats.add(new Seat("C" + (i + 1), true));
        }
        this.name = name;
    }

    Room(String name) {
        this.name = name;
    }

    public List<Seat> getAvalaibleSeat() {
        List<Seat> availables = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.isFree()) {
                availables.add(seat);
            }
        }
        return availables;
    }

    public String getName() {
        return name;
    }

    public void reset() {
        for (Seat seat : seats) {
            seat.setFree(true);
        }
    }

    boolean booking(String[] seats) {

        boolean ok = true;
        for (String seat : seats) {
            if (!this.seats.get(this.seats.indexOf(new Seat(seat))).isFree()) {
                ok = false;
            }
        }

        if (ok) {
            for (String seat : seats) {
                this.seats.get(this.seats.indexOf(new Seat(seat))).setFree(false);
            }
        }
        return ok;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        return Objects.equals(this.name, other.name);
    }

}
