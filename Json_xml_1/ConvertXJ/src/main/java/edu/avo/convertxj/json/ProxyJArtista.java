/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.json;

import java.time.LocalDate;

/**
 *
 * @author eugen
 */
public class ProxyJArtista {
    
    private String cognome;
    private String nome;
    private LocalDate nascita;

    public ProxyJArtista() {
    }

    public ProxyJArtista(String cognome, String nome, LocalDate nascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.nascita = nascita;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }
    
}
