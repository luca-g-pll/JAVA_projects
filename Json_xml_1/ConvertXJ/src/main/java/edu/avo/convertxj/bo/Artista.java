/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;

import java.time.LocalDate;

/**
 *
 * @author eugen
 */
public class Artista {
    
    private String cognome;
    private String nome;
    private LocalDate nascita;

    public Artista(String cognome, String nome, LocalDate nascita) {
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

    @Override
    public String toString() {
        return "Artista{" + "cognome=" + cognome + ", nome=" + nome + ", nascita=" + nascita + '}';
    }
    
}
