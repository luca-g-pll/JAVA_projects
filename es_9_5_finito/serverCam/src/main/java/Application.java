import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetAddress;

public class Application implements IApplicationObserver {


    SenderProtocolManager spm;
    FrameGrabber grabber;

    public Application(SenderProtocolManager spm) {
        this.spm = spm;
    }

    //aggiustare
    @Override
    public void remove() {
        if(grabber != null){
            try {
                grabber.stop();
            } catch (FrameGrabber.Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void capture(InetAddress address, int port) {
        grabber = new OpenCVFrameGrabber(0);

        //testa se la camera funziona
        try {
            grabber.start();
        } catch (FrameGrabber.Exception e) {
            throw new RuntimeException(e);
        }

        while (true) {
            Java2DFrameConverter paintConverter = new Java2DFrameConverter();
            try {
                BufferedImage bi = paintConverter.getBufferedImage(grabber.grab());
                BufferedImage im = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
                Graphics g = im.createGraphics();
                g.drawImage(bi.getScaledInstance(150, 150, Image.SCALE_SMOOTH), 0, 0, null);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(im, "png", baos);
                spm.sendUpdate(baos.toByteArray(), address, port);
            } catch (Exception e) {
                System.out.println("Broblem in while");
            }
        }
    }
}
