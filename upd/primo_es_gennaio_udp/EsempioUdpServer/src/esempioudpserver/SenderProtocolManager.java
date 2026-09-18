/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpserver;

import edu.avo.udplibcom.Sender;
import java.net.InetAddress;

/**
 *
 * @author MULTI01
 */
public class SenderProtocolManager {

    Sender sender;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
    }
            
    void sendEvenOddOutcome(byte command, byte value, boolean even, InetAddress address, int port) {
        byte [] array=new byte[3];
        array[2]=command;
        array[1]=value;
        array[0]=1;
        if(even){
            array[0]=0;
        }
        sender.send(array, address, port);
    }

    void sendLessGreaterOutcome(byte command, byte value, boolean less, InetAddress address, int port) {
        byte [] array=new byte[3];
        array[2]=command;
        array[1]=value;
        array[0]=1;
        if(less){
            array[0]=0;
        }
        sender.send(array, address, port);
    }
    
}
