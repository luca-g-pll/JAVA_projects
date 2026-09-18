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
    //value1/2 sono massimo '255' poichè devono stare il 1 byte massimo, il risultato no
    void calcSum(byte op, byte value1, byte value2, InetAddress address, int port);

    void calcSub(byte op, byte value1, byte value2, InetAddress address, int port);

    void calcMul(byte op, byte value1, byte value2, InetAddress address, int port);

    void calcDiv(byte op, byte value1, byte value2, InetAddress address, int port);


}
