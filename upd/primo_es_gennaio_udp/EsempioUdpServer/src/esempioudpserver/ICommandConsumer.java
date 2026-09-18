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
public interface ICommandConsumer {
    void controlOddEven(byte command, byte value,InetAddress address, int port);
    void controlLessGreater(byte command, byte value,InetAddress address, int port);
}
