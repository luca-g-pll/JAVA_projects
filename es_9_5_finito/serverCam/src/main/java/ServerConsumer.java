/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author nicol
 */

import librerie.IDataConsumer;

import java.net.InetAddress;

public class ServerConsumer implements IDataConsumer {

    IApplicationObserver app;


    public ServerConsumer(IApplicationObserver app) {
        this.app = app;
    }

    @Override
    public void consumeData(byte[] data, int dataLegth, InetAddress address, int port) {
        String messaggio = new String(data);
        String[] command = messaggio.split("#");
        System.out.println(command[0]);
        switch (command[0]) {
            case "add" -> {
                app.capture(address, port);
            }
            case "stop" -> {
                try {
                    app.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
