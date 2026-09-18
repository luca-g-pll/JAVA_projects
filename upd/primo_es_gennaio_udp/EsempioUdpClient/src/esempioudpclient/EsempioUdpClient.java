/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esempioudpclient;

import edu.avo.udplibcom.Receiver;
import edu.avo.udplibcom.Sender;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author MULTI01
 */
public class EsempioUdpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, UnknownHostException {
        DatagramSocket socket=new DatagramSocket();
        Sender sender =new Sender(socket);
        SenderProtocolManager spm=new SenderProtocolManager(sender);
        Application app=new Application(spm);
        Receiver receiver=new Receiver(socket, 5);
        ReceiverProtocolManager rpm=new ReceiverProtocolManager(app);
        receiver.setConsumer(rpm);
        
        app.send((byte)1,(byte)201, InetAddress.getByName("127.0.0.1"),60000);
    }
    
}
