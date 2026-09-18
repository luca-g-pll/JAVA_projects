/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esempioudpserver;

import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 *
 * @author MULTI01
 */
public class Application implements ICommandConsumer {

    private SenderProtocolManager sender;
    byte[] arrayByte;

    public Application(SenderProtocolManager sender) {
        this.sender = sender;
        arrayByte = new byte[2]; //array di byte in cui inserire il numero intero
    }

    //metodo per somma
    @Override
    public void calcSum(byte op, byte value1, byte value2, InetAddress address, int port) {
        int resultSum = (0xFF & value1) + (0xFF & value2) ;
        sender.sendOutcome(op,value1,value2,address,port,resultSum);

    }
    //metodo per sottrazione
    @Override
    public void calcSub(byte op, byte value1, byte value2, InetAddress address, int port) {
        int resultSub =(int) Math.abs((0xFF & value1) - (0xFF & value2)) ;
        sender.sendOutcome(op,value1,value2,address,port,resultSub);

    }
    //metodo per moltiplicazione
    @Override
    public void calcMul(byte op, byte value1, byte value2, InetAddress address, int port) {
        int resultMul = (0xFF & value1) * (0xFF & value2) ;
        sender.sendOutcome(op,value1,value2,address,port,resultMul);

    }
    //metodo per divisione
    @Override
    public void calcDiv(byte op, byte value1, byte value2, InetAddress address, int port) {
        int resultDiv = (0xFF & value1) / (0xFF & value2) ;
        sender.sendOutcome(op,value1,value2,address,port,resultDiv);


    }



}
