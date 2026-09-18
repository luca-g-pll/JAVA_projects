/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.json;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eugen
 */
public class ProxyJAlbum {
    
    private String titoloAlbum;
    private int anno;
    private List<String> titoliBrani;

    public ProxyJAlbum() {
    }

    public ProxyJAlbum(String titoloAlbum, int anno, List<String> titoliBrani) {
        this.titoloAlbum = titoloAlbum;
        this.anno = anno;
        this.titoliBrani = titoliBrani;
        titoliBrani = new ArrayList<String>();
    }

    public String getTitoloAlbum() {
        return titoloAlbum;
    }

    public int getAnno() {
        return anno;
    }

    public void setTitoloAlbum(String titoloAlbum) {
        this.titoloAlbum = titoloAlbum;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setTitoliBrani(List<String> titoliBrani) {
        this.titoliBrani = titoliBrani;
    }

    public List<String> getTitoliBrani() {
        return titoliBrani;
    }
    
}
