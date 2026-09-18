/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;




/**
 *
 * @author palma
 */
public class MapEntry {

    @XmlAttribute
    public String materia;

    @XmlElement
    public ProxyXInsegnante insegnante;
}
