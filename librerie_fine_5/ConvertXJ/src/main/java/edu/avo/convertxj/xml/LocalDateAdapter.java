/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

/**
 *
 * @author MULTI01
 */
import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;


 
public class LocalDateAdapter
    extends XmlAdapter<String, LocalDate>{
 
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }
 
    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
 
}
