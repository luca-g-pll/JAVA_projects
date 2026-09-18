/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;

import io.IMessageConsumer;

/**
 *
 * @author palma
 */
public class ReceiverProtocolManager implements IMessageConsumer {

    ICommandConsumer consumer;

    public ReceiverProtocolManager(ICommandConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void consumeMessage(String message) {
        String[] array = message.split("\\*");
        String command = array[0];
        String[] parameters = null;
        if (array.length > 1) {
            parameters = array[1].split("\\$");
        }
        switch (command) {
            case "AvailableSeats" -> {
                if (parameters != null && parameters.length > 2) {
                    consumer.availableSeats(parameters[0], parameters[1], parameters[2]);
                } else {
                    consumer.error("Missing parameters");
                }
            }
            case "Booking" -> {
                if (parameters != null && parameters.length > 3) {
                    String[] seats = parameters[3].split("#");
                    if (seats != null && seats.length > 0) {
                        consumer.booking(parameters[0], parameters[1], parameters[2], seats);
                    } else {
                        consumer.error("Missing parameters");
                    }

                } else {
                    consumer.error("Missing parameters");
                }
            }
            case "Quit" ->
                close();
            default ->
                consumer.error("Unkwon command");

        }

    }

    @Override
    public void close() {
        consumer.close();
    }

}
