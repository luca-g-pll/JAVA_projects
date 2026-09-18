package org.example;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.GridLayout;
import java.awt.Image;
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

/**
 * @author nicol
 */
public class View extends JFrame implements IApplicationObserver {

    Map<String, JLabel> cams;
    int width;
    int height;
    JButton aggiungi;
    JButton rimuovi;
    SenderProtocolManager spm;

    public View(SenderProtocolManager spm) {
        cams = new HashMap<String, JLabel>();
        this.setLayout(new GridLayout());
        this.spm = spm;
        width = 1080;
        height = 720;
        aggiungi = new JButton("Aggiungi");
        rimuovi = new JButton("Rimuovi");
        setButtonListeners();
        this.add(aggiungi);
        this.add(rimuovi);
        this.setVisible(true);

    }

    @Override
    public void updateFrame(String camName, byte[] imgBytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
            BufferedImage ds = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
            ds = ImageIO.read(bis);
            cams.get(camName).setIcon(new ImageIcon(ds));
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
        this.setVisible(true);
    }

    private void removeCam(String camName) {
        this.cams.remove(camName);
        width -= 160;
    }

    private void setButtonListeners() {

        aggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ip = JOptionPane.showInputDialog("Inserire IP del dispositivo");
                try {
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
                    spm.sendAdd(InetAddress.getByName(ip));
                } catch (UnknownHostException ex) {
                    JOptionPane.showInternalMessageDialog(View.this, "Pazzia, hai sbagliato l'IP!1!1!1!");
                }
            }
        });
    }
}
