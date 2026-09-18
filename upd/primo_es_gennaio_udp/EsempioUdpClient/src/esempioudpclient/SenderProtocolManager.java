/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpclient;

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
            
    void sendRequest(byte command, byte value, InetAddress address, int port) {
        byte [] array=new byte[2];
        array[1]=command;
        array[0]=value;
        sender.send(array, address, port);
    }
}
