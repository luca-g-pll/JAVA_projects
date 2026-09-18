/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempiominimale;

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
        String[] array = message.split("#");
        String command = array[0];
        String[] parameters = null;
        if (array.length > 1) {
            parameters = array[1].split("!");
        }
        switch (command) {
            case "Login" -> {
                if (parameters != null && parameters.length == 1) {
                    consumer.login(parameters[0]);
                } else {
                    consumer.error(2);
                }
            }
            case "Logout" -> {
                if (parameters == null || parameters.length == 0) {
                    consumer.logout();
                    consumer.close();
                } else {
                    consumer.error(2);
                }
            }
            case "Message" -> {
                if (parameters != null && parameters.length == 1) {
                    consumer.message(parameters[0]);
                } else {
                    consumer.error(2);
                }
            }
            default -> {
                consumer.error(1);

            }
        }
    }

    @Override
    public void close() {
        consumer.close();
    }

}
