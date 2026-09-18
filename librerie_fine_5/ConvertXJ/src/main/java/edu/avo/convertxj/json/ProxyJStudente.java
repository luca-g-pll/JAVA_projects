/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.json;

import edu.avo.convertxj.bo.Insegnante;
import edu.avo.convertxj.bo.Studente;
import edu.avo.convertxj.bo.Voto;
import jakarta.json.bind.annotation.JsonbTransient;
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
public class ProxyJStudente {
    
    private String matricola;
    private String nome;    
    private String cognome;   
    private LocalDate dataNascita;
    private List<ProxyJVoto> voti;
    private Map<String, ProxyJInsegnante> insegnamenti;

    public ProxyJStudente(Studente s) {
        this.matricola = s.getMatricola();
        this.nome = s.getNome();
        this.cognome = s.getCognome();
        this.dataNascita = s.getDataNascita();
        
        voti = new ArrayList<>();
        insegnamenti = new HashMap<>();
        
        int size=s.size();
        for(int i=0;i<size;i++){
            Voto v=s.get(i);
           voti.add(new ProxyJVoto(v.getMateria(),v.getData(),v.getVoto()));
        }
        Set<String> keys=s.keySet();
        for(String key: keys){
            Insegnante i=s.get(key);
            insegnamenti.put(key, new ProxyJInsegnante(i.getNome(),i.getCognome(),i.getMatricola()));
        }

    }

    public ProxyJStudente() {
    }


    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<ProxyJVoto> getVoti() {
        return voti;
    }

    public Map<String, ProxyJInsegnante> getInsegnamenti() {
        return insegnamenti;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setVoti(List<ProxyJVoto> voti) {
        this.voti = voti;
    }

    public void setInsegnamenti(Map<String, ProxyJInsegnante> insegnamenti) {
        this.insegnamenti = insegnamenti;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    
    @JsonbTransient
    public Studente getStudente(){
        Studente s=new Studente(matricola, nome, cognome, dataNascita);
        for(ProxyJVoto voto: voti){
            s.add(new Voto(voto.getMateria(),voto.getData(),voto.getVoto()));
        }
        Set<String> keys=insegnamenti.keySet();
        for(String key: keys){
            ProxyJInsegnante i=insegnamenti.get(key);
            s.put(key, new Insegnante(i.getNome(),i.getCognome(),i.getMatricola()));
        }
        return s;
    }

    

}
