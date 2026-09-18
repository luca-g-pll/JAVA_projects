package org.example;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JFrame implements IApplicationObserver {

    Map<String, JLabel> cams;
    JButton aggiungi;
    JButton rimuovi;
    SenderProtocolManager spm;
    JLabel camera;

    public View(SenderProtocolManager spm) {
        cams = new HashMap<String, JLabel>();
        this.setLayout(new GridLayout());
        this.spm = spm;
        aggiungi = new JButton("Aggiungi");
        rimuovi = new JButton("Rimuovi");
        camera = new JLabel();
        setButtonListeners();
        this.add(aggiungi);
        this.add(rimuovi);
        this.add(camera);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void updateFrame(String camName, byte[] imgBytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
            BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
            ds = ImageIO.read(bis);
            camera.setIcon(new ImageIcon(ds));
        } catch (IOException ex) {
            System.out.println("Errore nell'aggiornamento della CAM: " + camName);
        }
    }

    @Override
    public void addCam(String camName) {
        JLabel l = new JLabel();
        l.setText(camName);
        cams.put(camName, l);
        this.add(l);
    }

    private void removeCam(String camName) {
        this.cams.remove(camName);
    }

    private void setButtonListeners() {

        aggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog("Inserire IP del dispositivo");
                try {
                    //controlla che l ip sia valido
                    spm.sendAdd(InetAddress.getByName(ip));
                } catch (UnknownHostException ex) {
                    JOptionPane.showInternalMessageDialog(View.this, "Pazzia, hai sbagliato l'IP!1!1!1!");
                }
            }
        });

        rimuovi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog("Inserire IP del dispositivo");
                try {
                    spm.sendRemove(InetAddress.getByName(ip));
                } catch (UnknownHostException ex) {
                    JOptionPane.showInternalMessageDialog(View.this, "Pazzia, hai sbagliato l'IP!1!1!1!");
                }
            }
        });
    }
}
