/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.avo.convertxj;

import edu.avo.convertxj.bo.Insegnante;
import edu.avo.convertxj.bo.Studente;
import edu.avo.convertxj.bo.Voto;
import edu.avo.convertxj.json.JSONUtility;
import edu.avo.convertxj.json.ProxyJInsegnante;
import edu.avo.convertxj.json.ProxyJStudente;
import edu.avo.convertxj.xml.MapAdapter;
import edu.avo.convertxj.xml.MapList;
import edu.avo.convertxj.xml.ProxyList;
import edu.avo.convertxj.xml.ProxyXInsegnante;
import edu.avo.convertxj.xml.ProxyXStudente;
import edu.avo.convertxj.xml.ProxyXVoto;
import edu.avo.convertxj.xml.XMLUtility;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.PropertyException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 *
 * @author palma
 */
public class ConvertXJ {

    
    /*
    object -> json
        Nessun vincolo
    object -> xml
        Annotazione per la radice e annotazioni per i campi
        in alternativa alle annotazioni per i campi i setter 
    json-> object 
        costruttore vuoto e setter
    xml -> Object
        costruttore vuoto e annotazioni per i campi o i setter
    */
    public static void main(String[] args) throws PropertyException, JAXBException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, Exception {
        Voto v1 = new Voto("italiano", LocalDate.parse("2023-11-11"), 6);
        Voto v2 = new Voto("matematica", LocalDate.now(), 7);       
        Studente s = new Studente("1212345", "Antonio", "Rossi", LocalDate.parse("2001-09-23"));
        s.add(v2);
        s.add(v1);
        
        s.put("Italiano", new Insegnante("Pippo", "Pippo", "11111"));
        s.put("Matematica", new Insegnante("Paperino", "Gastone", "11222"));

        System.out.println("------Dati dello studente-------");
        System.out.println(s);

        System.out.println("\n\n\n\n------Json dello studente-------");
        String json = JSONUtility.toJson(new ProxyJStudente(s), true);       
        System.out.println(json);
        
        System.out.println("\n\n\n\n------Studente ricostruito dal Json-------");
        Studente s2 = ((ProxyJStudente) JSONUtility.toObject(json, ProxyJStudente.class)).getStudente();        
        System.out.println(s2);

        System.out.println("\n\n\n\n------Xml dello studente-------");
        String xml = XMLUtility.toXml(ProxyXStudente.class, new ProxyXStudente(s), true);       
        System.out.println(xml);

        System.out.println("\n\n\n\n------Studente ricostruito dall'Xml-------");
        Studente s3 = ((ProxyXStudente) XMLUtility.toObject(ProxyXStudente.class, xml)).getStudente();        
        System.out.println(s3);

        System.out.println("\n\n\n\n------Json di una lista-------");
        List<Voto> list = new ArrayList<>();
        list.add(v2);
        list.add(v1);
        json = JSONUtility.toJson(list, false);        
        System.out.println(json);

        System.out.println("\n\n\n\n------List ricostruita dal Json-------");
        list = (List) JSONUtility.toObject(json, ArrayList.class);        
        System.out.println(list);

        System.out.println("\n\n\n\n------Xml di una lista-------");
        ProxyXVoto pv1 = new ProxyXVoto(v1);
        ProxyXVoto pv2 = new ProxyXVoto(v2);
        ProxyList newList = new ProxyList();
        newList.add(pv1);
        newList.add(pv2);        
        xml = XMLUtility.toXml(ProxyList.class, newList, true);
        System.out.println(xml);

        System.out.println("\n\n\n\n------List ricostruita dal Xml-------");
        System.out.println(((ProxyList) XMLUtility.toObject(ProxyList.class, xml)).getListVoti());

         System.out.println("\n\n\n\n------Json di una map-------");
        Map<String, ProxyJInsegnante> mapj = new TreeMap<>();
        mapj.put("Italiano", new ProxyJInsegnante("Pippo", "Pippo", "11111"));
        mapj.put("Matematica", new ProxyJInsegnante("Paperino", "Gastone", "11222"));
        json = JSONUtility.toJson(mapj, true);       
        System.out.println(json);

        System.out.println("\n\n\n\n------Map ricostruita dal Json-------");
        System.out.println((Map)JSONUtility.toObject(json,TreeMap.class));
        
        System.out.println("\n\n\n\n------Xml da una map-------");
        Map<String, Insegnante> mapp=new TreeMap<>();
        mapp.put("Italiano",new Insegnante("Pippo", "Pippo", "11111"));
        mapp.put("Matematica",new Insegnante("Paperino", "Gastone", "11222"));       
        Map<String, ProxyXInsegnante> mapx = new TreeMap<>();
        Set<String> keys=mapp.keySet();
        for(String key: keys){
            mapx.put(key, new ProxyXInsegnante(mapp.get(key)));
        }
        MapAdapter ma = new MapAdapter();
        MapList ml = ma.marshal(mapx);
        xml = XMLUtility.toXml(MapList.class, ml, true);
        System.out.println(xml);
        
        System.out.println("\n\n\n\n------Map ricostruita dall'xml-------");
        ml=(MapList) XMLUtility.toObject(MapList.class, xml);
        mapx=ma.unmarshal(ml);
        mapp.clear();
        keys=mapx.keySet();
        for(String key: keys){
            mapp.put(key, mapx.get(key).getInsegnante());
        }
        System.out.println(mapp);
    }
}
