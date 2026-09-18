/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eugen
 */
public class Album {
    
    private String titoloAlbum;
    private int anno;
    private List<String> titoliBrani;

    public Album(String titoloAlbum, int anno) {
        this.titoloAlbum = titoloAlbum;
        this.anno = anno;
        titoliBrani = new ArrayList<String>();
    }

    public String getTitoloAlbum() {
        return titoloAlbum;
    }

    public int getAnno() {
        return anno;
    }

    public List<String> getTitoliBrani() {
        return titoliBrani;
    }
    
    public void add(String titolo) {
        titoliBrani.add(titolo);
    }
    
    public int titoliSize() {
        return titoliBrani.size();
    }
    
    public String getTitoloBrano(int index) {
        return titoliBrani.get(index);
    }
    
}
