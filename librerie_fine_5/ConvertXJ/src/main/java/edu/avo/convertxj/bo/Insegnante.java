/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;



/**
 *
 * @author palma
 */

public class Insegnante {
    

    private  String nome;

    private  String cognome;

    private  String matricola;

    public Insegnante(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getMatricola() {
        return matricola;
    }  


    @Override
    public String toString() {
        return "Insegnante{" + "nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + '}';
    }
       
}
