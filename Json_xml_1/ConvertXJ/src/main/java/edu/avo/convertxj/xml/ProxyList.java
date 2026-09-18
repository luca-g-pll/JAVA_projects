/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Artista;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author palma
 */
@XmlRootElement(name="artisti")
public class ProxyList {

    @XmlElement(name = "artista")
    List<ProxyXArtista> list;

    public ProxyList() {
        list=new ArrayList<>();
    }

    public boolean add(ProxyXArtista e) {
        return list.add(e);
    }

    public List<ProxyXArtista> getLista() {
        return list;
    }

    public List<Artista> getListArtisti(){
        List<Artista> newList=new ArrayList<>();
        for(ProxyXArtista a: list){
            Artista artista=a.getArtista();
            newList.add(new Artista(artista.getCognome(),artista.getNome(),artista.getNascita()));
        }
        return newList;
    }
    
    
}
