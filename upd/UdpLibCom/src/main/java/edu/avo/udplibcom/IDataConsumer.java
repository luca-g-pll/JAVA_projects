/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.avo.udplibcom;

import java.net.InetAddress;

/**
 *
 * @author MULTI01
 */
public interface IDataConsumer {
    void consumeData(byte [] data, int dataLegth, InetAddress address, int port);
}
