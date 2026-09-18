package server;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: ICommandConsumer (interface) --> Descritti i metodi che implementerà l'application
 */
import java.net.InetAddress;

public interface ICommandConsumer {

    //metodo per l'acquisizione delle immagini, le invierà al senderProtocolManger per inviarle al client
    void capture(InetAddress address, int port);
    //metodo per l'arresto dell'acquisizione delle immagini del sistema
    void stopCapture();
}
