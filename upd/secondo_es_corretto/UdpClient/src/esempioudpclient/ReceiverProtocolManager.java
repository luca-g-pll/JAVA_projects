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
        switch(bytes[0]){
            case 1->{ //+
                consumer.printSum(bytes[0], bytes[1], bytes[2], bytes[3], bytes[4]);
            }
            case 2->{//-
                consumer.printSub(bytes[0], bytes[1], bytes[2], bytes[3], bytes[4]);
            }
            case 3->{// *
                consumer.printMul(bytes[0], bytes[1], bytes[2], bytes[3], bytes[4]);
            }
            case 4->{// /
                consumer.printDiv(bytes[0], bytes[1], bytes[2], bytes[3], bytes[4]);
            }
        }
    }
    
}
