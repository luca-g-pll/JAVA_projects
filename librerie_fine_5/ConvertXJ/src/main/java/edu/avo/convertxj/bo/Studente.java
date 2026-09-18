/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MULTI01
 */


public class Studente {


    private final String matricola;
    private final String nome;    
    private final String cognome;   
    private final LocalDate dataNascita;
    private final List<Voto> voti;
    private final Map<String, Insegnante> insegnamenti;

    public Studente(String matricola, String nome, String cognome, LocalDate dataNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        voti = new ArrayList<>();
        insegnamenti = new HashMap<>();
    }

    public Insegnante get(String key) {
        return insegnamenti.get(key);
    }

    public Insegnante put(String key, Insegnante value) {
        return insegnamenti.put(key, value);
    }

    public Set<String> keySet() {
        return insegnamenti.keySet();
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public int size() {
        return voti.size();
    }

    public boolean add(Voto e) {
        return voti.add(e);
    }

    public Voto get(int index) {
        return voti.get(index);
    }

    @Override
    public String toString() {
        return "Studente{" + "matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", voti=" + voti + ", insegnamenti=" + insegnamenti + '}';
    }

    

}
