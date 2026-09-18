package org.example;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class Main {


    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException, IOException {


        //Cambio logica, il client ora si comporterà da server e il client sarà 1 solo che riceverà i pacchetti
        //Dai server a cui si collega.


        DatagramSocket socket = new DatagramSocket();

        Sender sender = new Sender(socket);
        SenderProtocolManager spm = new SenderProtocolManager(sender);
        IApplicationObserver obs = new View(spm);
        IDataConsumer dataCons = new ClientConsumer(obs);
        Receiver r = new Receiver(socket, 65500);
        r.setConsumer(dataCons);


    }
}