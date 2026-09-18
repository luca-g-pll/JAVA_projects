/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author palma
 */
public class MapAdapter extends XmlAdapter<MapList, Map<String, ProxyXInsegnante>> {

    @Override
    public Map<String, ProxyXInsegnante> unmarshal(MapList vt) throws Exception {
        Map<String, ProxyXInsegnante> map = new HashMap<>();
        for (MapEntry entry : vt.insegnamento) {
            map.put(entry.materia, entry.insegnante);
        }
        return map;
    }

    @Override
    public MapList marshal(Map<String, ProxyXInsegnante> bt) throws Exception {
        MapList m = new MapList();
        Set<String> keys = bt.keySet();
        MapEntry entry;
        for (String key : keys) {
            entry = new MapEntry();
            entry.materia = key;
            entry.insegnante = bt.get(key);
            m.insegnamento.add(entry);
        }
        return m;
    }

}
