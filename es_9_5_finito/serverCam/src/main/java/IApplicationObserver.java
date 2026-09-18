/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import librerie.Sender;

import java.net.InetAddress;

/**
 * @author MULTI01
 */
public interface IApplicationObserver {
    void capture(InetAddress address, int port);

    void remove();
}
