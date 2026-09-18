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

    //volendo posso spedire un bytes[] contente i due byte ???

    void sendOutcome(byte command, byte value1, byte value2, InetAddress address, int port, int result) {
        byte [] array=new byte[5];
        byte [] arrayresult = new byte[2];
        array[2]=value2;
        array[1]=value1;
        array[0]=command;

        arrayresult = intToByteArray(result);

        array[3] = arrayresult[0];
        array[4] = arrayresult[1];

        sender.send(array, address, port);
    }

    //metodo per la creazione del byte[] array per il numero risultato
    private static byte[] intToByteArray(int value) {
        byte[] byteArray = new byte[2];
        for (int i = 0; i < 2; i++) {
            byteArray[i] = (byte) (value >> (i * 8));
        }
        return byteArray;
    }
    
}
