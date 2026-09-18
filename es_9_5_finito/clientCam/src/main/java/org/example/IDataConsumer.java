package org.example;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.net.InetAddress;

public interface IDataConsumer {
    void consumeData(byte [] data, int dataLegth, InetAddress address, int port);
}
