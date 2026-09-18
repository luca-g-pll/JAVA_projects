/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.bo;


import java.time.LocalDate;

/**
 *
 * @author MULTI01
 */
public class Voto {
    
    private  String materia;
    private  LocalDate data;    
    private  int voto;

    public Voto(String materia, LocalDate data, int voto) {
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

    @Override
    public String toString() {
        return "Voto{" + "materia=" + materia + ", data=" + data + ", voto=" + voto + '}';
    }
    
}
