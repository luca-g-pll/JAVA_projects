/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cinema;

/**
 *
 * @author MULTI01
 */
public interface ICommandConsumer {
    void information();
    void availableSeats(String room, String hour, String day);
    void booking(String room,String hour,String day, String [] seats);
    void error(String code);
    void close();
}
