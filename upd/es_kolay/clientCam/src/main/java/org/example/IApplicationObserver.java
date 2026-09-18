/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.example;

/**
 *
 * @author MULTI01
 */
public interface IApplicationObserver {

    void updateFrame(String camName, byte[] imgBytes);

    void addCam(String camName);

}
