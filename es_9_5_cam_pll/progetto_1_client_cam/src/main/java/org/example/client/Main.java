package org.example.client;
/**
 *  *      Pillitu Luca - 5CI - febbraio 2024
 *  *
 *  *      progetto per acquisizione ed invio immagini per byte tra un client e n. server
 *  *
 *  *
 *  *  -- file: Main
 *         //il client invierà al client un messaggio di connessione
 *         //dove il client tramite ip e porta si connette al server
 *         //e il server invia le i immagini in byte
 *
 *
 *         //per inviare al client i pacchetti posso usare una immagine 200x200 da 40000 byte (40kbt)
 *         //il client quando riceve il pacchetto o se riceve tutti i pacchetto
 *         //quando il client sa di aver ricevuto tutti i byte della foto manda un ok per richidere la foto successiva
 *         //la foto può essere compattata in 200x200 o 150x150 e mandata in blocco unico in teoria
 */
import java.net.SocketException;

public class Main {

    //ci sarà solamente 1 client e molti server (logica inversa in cui il client si comporta da server e riceve i pacchetti)
    //pacchetti ricevuti dai server a cui si collega
    public static void main(String[] args) throws SocketException {

        new InputFrame();

    }
}
