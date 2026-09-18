/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Album;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eugen
 */
@XmlRootElement(name="album")
public class ProxyXAlbum {
    @XmlAttribute
    private String titoloAlbum;
    @XmlAttribute
    private int anno;
    @XmlAttribute
    private List<String> titoliBrani;

    public ProxyXAlbum() {
    }
    
    public ProxyXAlbum(Album a){
        titoloAlbum=a.getTitoloAlbum();
        anno=a.getAnno();
        titoliBrani=a.getTitoliBrani();
    }
    
    public Album getAlbum(){
        Album album = new Album(titoloAlbum, anno);
        int size = titoliBrani.size();
        for(int i = 0; i < size; i++) {
            album.add(titoliBrani.get(i));
        }
        return album;
    }

    @Override
    public String toString() {
        return "ProxyXAlbum{" + "titoloAlbum=" + titoloAlbum + ", anno=" + anno + ", titoliBrani=" + titoliBrani.toString() + '}';
    }
    
}
