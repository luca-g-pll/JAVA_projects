/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;

import edu.avo.convertxj.xml.MapEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author eugen
 */
public class GruppoMusicale {
    
    private String nome;
    private List<Artista> artisti;
    private Map<String, Album> album;
    private String annoFondazione;

    public GruppoMusicale(String nome, String annoFOndazione) {
        this.nome = nome;
        this.annoFondazione = annoFOndazione;
        artisti = new ArrayList<Artista>();
        album = new HashMap<String, Album>();
    }

    public String getNome() {
        return nome;
    }

    public String getAnnoFondazione() {
        return annoFondazione;
    }
    
    public void addArtista(Artista artista) {
        artisti.add(artista);
    }
    
    public int artistiSize() {
        return artisti.size();
    }
    
    public Artista getArtista(int index) {
        return artisti.get(index);
    }
    
    public Set<String> getAlbumKeys(){
        return album.keySet();
    }
    
    public Album getAlbum(String key) {
        return album.get(key);
    }
    
    public void put(String key, Album value) {
        album.put(key, value);
    }
    
}
