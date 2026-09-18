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

    public Application(SenderProtocolManager spm) {
        this.spm = spm;
    }


    @Override
    public void stop() {
        this.stop();
    }

    @Override
    public void capture(InetAddress address, int port) {
        FrameGrabber grabber = new OpenCVFrameGrabber(0);
        BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
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

                System.out.println("sto prendendo la foto");
            } catch (Exception e) {
                System.out.println("Broblem in while");
            }


        }
    }
}
