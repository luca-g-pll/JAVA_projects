package senderPack;

        import java.io.*;
        import java.net.Socket;

public class Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 60000);

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        String message = br.readLine();

        OutputStreamWriter w = new OutputStreamWriter(socket.getOutputStream());
        w.write(message);
        w.flush();

        InputStreamReader r2 = new InputStreamReader(socket.getInputStream());

        LOOP: while (true) {
            System.out.println(r2.read());
        }
    }
}