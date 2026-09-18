/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpserver;

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
    
    //il risultato devo dividerlo in 2 byte --> facendo il modulo per il least significant byte e la divisione per 255 per il most significant
    //nel client dovro ricomporre i due byte separati per mostrarli a video

    @Override
    public void consumeData(byte[] bytes, int i, InetAddress ia, int i1) {//i1 porta - ia indirizzo che bisognerà passare al sender per inviare al client
        switch(bytes[0]) {
            //riceverò al massimo 3 byte dal client che saranno le informazioni per le operazioni che dovro mandare al metodo come byte[1] - [2] - [0]
            case 1 -> { // +
                consumer.calcSum(bytes[0], bytes[1], bytes[2], ia, i1);
            }
            case 2 -> {// -
                consumer.calcSub(bytes[0], bytes[1], bytes[2], ia, i1);
            }
            case 3 -> {// *
                consumer.calcMul(bytes[0], bytes[1], bytes[2], ia, i1);
            }
            case 4 -> {// /
                consumer.calcDiv(bytes[0], bytes[1], bytes[2], ia, i1);
            }
        }
    }
    
}
