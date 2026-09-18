/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import edu.avo.convertxj.bo.Studente;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;




/**
 *
 * @author palma
 */
@XmlRootElement(name="studente")
public class ProxyXStudente {
    @XmlAttribute
    private String matricola;
    @XmlAttribute
    private String nome;
    @XmlAttribute
    private String cognome;
    @XmlAttribute
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate dataNascita;
    @XmlElementWrapper(name = "voti")
    @XmlElement(name = "voto")
    private List<ProxyXVoto> voti;
    @XmlJavaTypeAdapter(value = MapAdapter.class)
    private Map<String, ProxyXInsegnante> insegnamenti;

    public ProxyXStudente(Studente s){
        matricola=s.getMatricola();
        nome=s.getNome();
        cognome=s.getCognome();
        dataNascita=s.getDataNascita();
        int size=s.size();
        voti=new ArrayList<>();
        for(int i=0;i<size;i++){
           voti.add(new ProxyXVoto(s.get(i)));
        }
        insegnamenti=new HashMap<>();
        Set<String> keys=s.keySet();
        for(String key: keys){
            insegnamenti.put(key, new ProxyXInsegnante(s.get(key)));
        }
    }
    
    public ProxyXStudente() {
    }
    
    public Studente getStudente(){
        Studente s=new Studente(matricola, nome, cognome, dataNascita);
        for(ProxyXVoto voto: voti){
            s.add(voto.getVoto());
        }
        Set<String> keys=insegnamenti.keySet();
        for(String key: keys){
            s.put(key, insegnamenti.get(key).getInsegnante());
        }
        return s;
    }
    
        
    
}
