/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Album;
import edu.avo.convertxj.bo.Artista;
import java.time.LocalDate;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author eugen
 */
@XmlRootElement(name="artista")
public class ProxyXArtista {
    @XmlAttribute
    private String cognome;
    @XmlAttribute
    private String nome;
    @XmlAttribute
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate nascita;

    public ProxyXArtista() {
    }
    
    public ProxyXArtista(Artista a){
        cognome=a.getCognome();
        nome=a.getNome();
        nascita=a.getNascita();
    }
    
    public Artista getArtista(){
        return new Artista(cognome, nome, nascita);
    }
    
}

