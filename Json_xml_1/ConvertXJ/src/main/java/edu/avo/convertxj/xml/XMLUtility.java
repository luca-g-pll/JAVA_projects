/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author palma
 */
public class  XMLUtility {

    public static String toXml(Class clazz, Object object, boolean formatted) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatted);
        StringWriter sw = new StringWriter();
        mar.marshal(object, sw);
        return sw.toString();
    }

    public static Object toObject(Class clazz, String xml) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(clazz);
        Unmarshaller um = jc.createUnmarshaller();
        return um.unmarshal(new StringReader(xml));

    }
}
