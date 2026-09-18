/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HexFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import static org.bytedeco.opencv.helper.opencv_imgcodecs.cvSaveImage;

import org.bytedeco.opencv.opencv_core.CvArr;
import org.bytedeco.opencv.opencv_core.IplImage;

/**
 *
 * @author palma
 */
public class Mavenproject1 {

    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException, IOException {

        FrameGrabber grabber = new OpenCVFrameGrabber(0);
        BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

        //contiene l'igm ds vuota inizializzata come icona di base  cone dimensioni delle img successoive
        JLabel l=new JLabel(new ImageIcon(ds));
        JFrame f = new JFrame();
        f.add(l);
        //ridimensione automatica della finestra per adattarsi alle dimensioni dei suoi componenti
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


        grabber.start();

        while (true) {
            Java2DFrameConverter paintConverter = new Java2DFrameConverter();           
            BufferedImage bi = paintConverter.getBufferedImage(grabber.grab());
            BufferedImage im = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
            Graphics g = im.createGraphics();
            g.drawImage(bi.getScaledInstance(150, 150, Image.SCALE_SMOOTH), 0, 0, null);           
            ByteArrayOutputStream baos=new ByteArrayOutputStream();

            ImageIO.write(im, "png", baos);

            //baos.toByteArray();
            ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());

            ds=ImageIO.read(bais);
            //impostata l'img presa come frame come icona del frame e quind  visualizzabile come img nel frame
            l.setIcon(new ImageIcon(ds));           
        }
    }
}

/* ALTRO MODO PER LANCIARE IL THREAD E POI INTERROMPERLO
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.InetAddress;
import javax.imageio.ImageIO;
import org.bytedeco.opencv.opencv_core.FrameGrabber;
import org.bytedeco.opencv.opencv_core.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

public class CameraCapture {
    private volatile boolean isRunning = false;
    private Thread captureThread;

    public void start() {
        isRunning = true;
        captureThread = new Thread(() -> {
            FrameGrabber grabber = new OpenCVFrameGrabber(0);
            BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
            try {
                grabber.start();
            } catch (FrameGrabber.Exception e) {
                throw new RuntimeException(e);
            }
            while (isRunning) {
                Java2DFrameConverter paintConverter = new Java2DFrameConverter();
                try {
                    BufferedImage bi = paintConverter.getBufferedImage(grabber.grab());
                    BufferedImage im = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
                    Graphics g = im.createGraphics();
                    g.drawImage(bi.getScaledInstance(150, 150, Image.SCALE_SMOOTH), 0, 0, null);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(im, "png", baos);

                    System.out.println("Sto prendendo la foto");
                } catch (Exception e) {
                    System.out.println("Problem in while");
                }
            }
            try {
                grabber.stop();
            } catch (FrameGrabber.Exception e) {
                e.printStackTrace();
            }
        });
        captureThread.start();
    }

    public void stop() {
        isRunning = false;
        captureThread.interrupt(); // Interrumpi il thread se è bloccato in un'operazione I/O
    }

    public void capture(InetAddress address, int port) {
        // Implementazione del metodo capture
    }

    public static void main(String[] args) {
        CameraCapture camera = new CameraCapture();
        camera.start();

        // Dormi per un po' di tempo per simulare l'attività
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        camera.stop();
    }
}

 */