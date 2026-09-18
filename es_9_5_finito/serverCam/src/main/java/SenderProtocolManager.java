/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import librerie.Sender;

import java.net.InetAddress;


/**
 *
 * @author nicol
 */
public class SenderProtocolManager {

    Sender sender;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;

    }

    public void sendUpdate(byte[] imgData,InetAddress address,int port) {
        sender.send(imgData, address, 60001);
    }

}
