/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpclient;

import java.net.InetAddress;


/**
 *
 * @author MULTI01
 */
public interface ICommandConsumer {
    void printLG(byte command, byte value, byte result);

    void printOE(byte command, byte value, byte result);
    
    void send(byte b, byte b0, InetAddress address, int port);
}
