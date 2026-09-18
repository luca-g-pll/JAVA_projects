/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.xml;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author palma
 */
public class MapAdapter extends XmlAdapter<MapList, Map<String, ProxyXAlbum>> {

    @Override
    public Map<String, ProxyXAlbum> unmarshal(MapList vt) throws Exception {
        Map<String, ProxyXAlbum> map = new HashMap<>();
        for (MapEntry entry : vt.album) {
            map.put(entry.titolo, entry.album);
        }
        return map;
    }

    @Override
    public MapList marshal(Map<String, ProxyXAlbum> bt) throws Exception {
        MapList m = new MapList();
        Set<String> keys = bt.keySet();
        MapEntry entry;
        for (String key : keys) {
            entry = new MapEntry();
            entry.titolo = key;
            entry.album = bt.get(key);
            m.album.add(entry);
        }
        return m;
    }

}
