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

    void printSum(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4);

    void printSub(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4);

    void printMul(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4);

    void printDiv(byte aByte, byte aByte1, byte aByte2, byte aByte3, byte aByte4);
}
