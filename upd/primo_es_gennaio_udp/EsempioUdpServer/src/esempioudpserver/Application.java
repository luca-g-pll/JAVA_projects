/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpserver;

import java.net.InetAddress;

/**
 *
 * @author MULTI01
 */
public class Application implements ICommandConsumer {

    private SenderProtocolManager sender;

    public Application(SenderProtocolManager sender) {
        this.sender = sender;
    }

    @Override
    public void controlOddEven(byte command, byte value, InetAddress address, int port) {
        boolean even = value % 2 == 0;
        sender.sendEvenOddOutcome(command, value, even, address, port);
    }

    @Override
    public void controlLessGreater(byte command, byte value, InetAddress address, int port) {
        int valueI = 0xFF & value;
        boolean less = valueI < 200;
        sender.sendLessGreaterOutcome(command, value, less, address, port);
    }

}
