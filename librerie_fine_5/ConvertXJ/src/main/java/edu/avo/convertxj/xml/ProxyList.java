/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Voto;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author palma
 */
@XmlRootElement(name="voti")
public class ProxyList {

    @XmlElement(name = "voto")
    List<ProxyXVoto> list;

    public ProxyList() {
        list=new ArrayList<>();
    }

    public boolean add(ProxyXVoto e) {
        return list.add(e);
    }

    public List<ProxyXVoto> getLista() {
        return list;
    }

    public List<Voto> getListVoti(){
        List<Voto> newList=new ArrayList<>();
        for(ProxyXVoto v: list){
            Voto voto=v.getVoto();
            newList.add(new Voto(voto.getMateria(),voto.getData(),voto.getVoto()));
        }
        return newList;
    }

}
