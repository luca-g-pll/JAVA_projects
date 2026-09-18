
package esempioudpclient;

import edu.avo.udplibcom.Receiver;
import edu.avo.udplibcom.Sender;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class UdpClient {


    public static void main(String[] args) throws SocketException, UnknownHostException {



            DatagramSocket socket = new DatagramSocket();
            Sender sender = new Sender(socket);

            SenderProtocolManager spm = new SenderProtocolManager(sender);
            Application app = new Application(spm);

            Receiver receiver = new Receiver(socket, 5);
            ReceiverProtocolManager rpm = new ReceiverProtocolManager(app);
            receiver.setConsumer(rpm);

            View view = new View(spm);

            //app.send((byte)1,(byte)201, InetAddress.getByName("127.0.0.1"),60000);

    }
    
}
