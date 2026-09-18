/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cinema.persistence;

import java.util.List;

/**
 *
 * @author MULTI01
 */
public interface IPersistence {

    List<Seat> selectFreeSeats(String room, String hour, String day);

    boolean booking(String romm, String hour, String day, String[] seats);

    List<String> selectRooms();

    List<String> selectHours();
}
