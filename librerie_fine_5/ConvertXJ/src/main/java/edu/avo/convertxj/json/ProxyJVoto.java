/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.json;

import java.time.LocalDate;

/**
 *
 * @author palma
 */
public class ProxyJVoto {

    private String materia;
    private LocalDate data;
    private int voto;
    
    
    public ProxyJVoto(){        
    }

    public ProxyJVoto(String materia, LocalDate data, int voto) {
        this.materia = materia;
        this.data = data;
        this.voto = voto;
    }
    
    
    public String getMateria() {
        return materia;
    }

    public LocalDate getData() {
        return data;
    }

    public int getVoto() {
        return voto;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
}
