/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import librerie.IDataConsumer;
import librerie.Receiver;
import librerie.Sender;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author palma
 */
public class Main {

    public static void main(String[] args) throws SocketException {
        /* FrameGrabber grabber = new OpenCVFrameGrabber(0);
        BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
        JLabel l = new JLabel(new ImageIcon(ds));
        JLabel k = new JLabel(new ImageIcon(ds));
        JFrame f = new JFrame();
        f.setLayout(new GridLayout());
        roba*/
        //IApplicationObserver obs = new View();

        DatagramSocket socket = new DatagramSocket(9999);
        Receiver r = new Receiver(socket, 65500);

        Sender sender = new Sender(socket);
        SenderProtocolManager spm = new SenderProtocolManager(sender);
        IApplicationObserver obs = new Application(spm);
        IDataConsumer dataCons = new ServerConsumer(obs);
        r.setConsumer(dataCons);

    }

}
