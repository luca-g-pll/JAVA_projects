/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpclient;

import edu.avo.udplibcom.IDataConsumer;
import java.net.InetAddress;

/**
 *
 * @author MULTI01
 */
public class ReceiverProtocolManager implements IDataConsumer{

    ICommandConsumer consumer;

    public ReceiverProtocolManager(ICommandConsumer consumer) {
        this.consumer = consumer;
    }
    
    
    @Override
    public void consumeData(byte[] bytes, int i, InetAddress ia, int i1) {
        switch(bytes[2]){
            case 0->{
                consumer.printOE(bytes[2], bytes[1], bytes[0]);
            }
            case 1->{
                consumer.printLG(bytes[2], bytes[1], bytes[0]);
            }
        }
    }
    
}
