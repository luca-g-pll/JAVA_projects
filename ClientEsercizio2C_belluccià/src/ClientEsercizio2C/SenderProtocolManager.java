package ClientEsercizio2C;

import io.Sender;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author MULTI01
 */
public class SenderProtocolManager {

    Sender sender;

    public SenderProtocolManager(Sender sender) {

        this.sender = sender;
    }

    public void send(String command, String string) {

        sender.send(command + "##" + string);
    }

    public void close(String forClose) {
            sender.send(forClose);
            sender.close();
    }
}
