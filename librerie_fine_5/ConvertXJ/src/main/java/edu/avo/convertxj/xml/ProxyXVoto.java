/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Voto;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;



/**
 *
 * @author palma
 */
@XmlRootElement
public class ProxyXVoto {
    
    @XmlAttribute
    private String materia;
    @XmlAttribute
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate data;    
    @XmlAttribute
    private int voto;

    public ProxyXVoto() {
    }
    
    public ProxyXVoto(Voto v) {
        materia=v.getMateria();
        data=v.getData();
        voto=v.getVoto();
    }

    public Voto getVoto(){
        return new Voto(materia, data, voto);
    }
}
