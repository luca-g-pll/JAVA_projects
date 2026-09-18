package server;

public class Main {
    public static void main(String[] args) {

        //il client invierà al client un messaggio di connessione
        //dove il client tramite ip e porta si connette al server
        //e il server invia le i immagini in byte


        //per inviare al client i pacchetti posso usare una immagine 200x200 da 40000 byte (40kbt)
        //il client quando riceve il pacchetto o se riceve tutti i pacchetto
        //quando il client sa di aver ricevuto tutti i byte della foto manda un ok per richidere la foto successiva
        //la foto può essere compattata in 200x200 o 150x150 e mandata in blocco unico in teoria
        //
    }
}