/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author palma
 */
@XmlRootElement(name="Insegnamenti")
public class MapList {
    @XmlElement(name = "insegnamento")
    public List<MapEntry> insegnamento=new ArrayList<>();
    
}
