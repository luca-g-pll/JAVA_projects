/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ClientEsercizio2C;

import io.IMessageConsumer;
import io.Reader;
import io.Sender;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author MULTI01
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("127.0.0.1", 60000);

        PrintWriter out=new PrintWriter(s.getOutputStream());
        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));

        Sender sender=new Sender(out);
        SenderProtocolManager spm=new SenderProtocolManager(sender);

        ICommandConsumer app=new Application1(spm);
        IMessageConsumer rpm=new ReceiverProtocolManager(app);

        Reader reader=new Reader(in,"Quit");
        reader.setConsumer(rpm);
    }  
}
