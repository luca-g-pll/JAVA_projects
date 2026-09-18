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
public class Application implements ICommandConsumer {

    private SenderProtocolManager sender;

    public Application(SenderProtocolManager sender) {
        this.sender = sender;
    }

    @Override
    public void printLG(byte command, byte value, byte result ){
        String resultS=" > ";
        if(result==0){
            resultS=" < ";
        }
        int valueI=0xFF & value;
        System.out.println(valueI +resultS+"200");
    }

    @Override
    public void printOE(byte command, byte value, byte result ){
        String resultS=" dispari ";
        if(result==0){
            resultS=" pari ";
        }
        System.out.println(value+resultS);
    }
    @Override
    public void send(byte b, byte b0, InetAddress address, int port) {
        sender.sendRequest(b, b0, address, port);
    }
}
