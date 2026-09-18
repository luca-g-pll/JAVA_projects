/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.GruppoMusicale;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author eugen
 */
@XmlRootElement(name="gruppoMusicale")
public class ProxyXGruppoMusicale {
    @XmlAttribute
    private String nome;
    @XmlAttribute
    private String annoFondazione;
    @XmlAttribute
    private String cognome;
    @XmlElementWrapper(name = "artisti")
    @XmlElement(name = "artista")
    private List<ProxyXArtista> artisti;
    @XmlJavaTypeAdapter(value = MapAdapter.class)
    private Map<String, ProxyXAlbum> album;

    public ProxyXGruppoMusicale(GruppoMusicale gm){
        nome=gm.getNome();
        annoFondazione=gm.getAnnoFondazione();
        int size=gm.artistiSize();
        artisti=new ArrayList<>();
        for(int i=0;i<size;i++){
           artisti.add(new ProxyXArtista(gm.getArtista(i)));
        }
        album=new HashMap<>();
        Set<String> keys=gm.getAlbumKeys();
        for(String key: keys){
            album.put(key, new ProxyXAlbum(gm.getAlbum(key)));
        }
    }
    
    public ProxyXGruppoMusicale() {
    }
    
    public GruppoMusicale getGruppoMusicale(){
        GruppoMusicale gm=new GruppoMusicale(nome, annoFondazione);
        for(ProxyXArtista artista: artisti){
            gm.addArtista(artista.getArtista());
        }
        Set<String> keys=album.keySet();
        for(String key: keys){
            gm.put(key, album.get(key).getAlbum());
        }
        return gm;
    }
    
}

