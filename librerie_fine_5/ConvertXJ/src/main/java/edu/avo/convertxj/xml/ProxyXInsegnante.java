/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;


import edu.avo.convertxj.bo.Insegnante;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author palma
 */
@XmlRootElement(name="insegnante")
public class ProxyXInsegnante {
    @XmlAttribute
    private String nome;
    @XmlAttribute
    private String cognome;
    @XmlAttribute
    private String matricola;

    public ProxyXInsegnante() {
    }
    
    public ProxyXInsegnante(Insegnante i){
        nome=i.getNome();
        cognome=i.getCognome();
        matricola=i.getMatricola();
    }
    
    public Insegnante getInsegnante(){
        return new Insegnante(nome, cognome, matricola);
    }

    @Override
    public String toString() {
        return "ProxyXInsegnante{" + "nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + '}';
    }
    
    
}
