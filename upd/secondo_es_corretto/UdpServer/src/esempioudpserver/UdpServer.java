
package esempioudpserver;
import edu.avo.udplibcom.Receiver;
import edu.avo.udplibcom.Sender;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;


public class UdpServer {
    public static void main(String[] args) throws SocketException {


            DatagramSocket socket = new DatagramSocket(60000);
            Sender sender = new Sender(socket);

            SenderProtocolManager spm = new SenderProtocolManager(sender);
            Application app = new Application(spm);

            Receiver receiver = new Receiver(socket, 5);
            ReceiverProtocolManager rpm = new ReceiverProtocolManager(app);
            receiver.setConsumer(rpm);
        }
    
}