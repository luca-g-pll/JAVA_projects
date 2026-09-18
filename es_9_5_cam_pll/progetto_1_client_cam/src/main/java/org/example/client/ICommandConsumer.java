package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: ICommandConsumer (interface) --> Descritti i metodi che implementerà l'application
 */
import java.io.IOException;
import java.net.InetAddress;

public interface ICommandConsumer {

    void updateFrame(Integer camName, byte[] imgBytes) throws IOException;

    void addCam(Integer camName, InetAddress address, Integer port, byte[] imgBytes) throws IOException;

}
