/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.net.InetAddress;

public class SenderProtocolManager {

    Sender sender;

    public SenderProtocolManager(Sender sender) {
        this.sender = sender;
    }

    public void sendAdd(InetAddress address) {
        String msg = "add#";
        byte[] bytes = msg.getBytes();
        sender.send(bytes, address, 60000);
    }

    public void sendRemove(InetAddress address){
        String msg = "stop#";
        byte[] bytes = msg.getBytes();
        sender.send(bytes,address,60000);
    }

}
