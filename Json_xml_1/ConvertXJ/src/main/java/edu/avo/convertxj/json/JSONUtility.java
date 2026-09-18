/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.avo.convertxj.json;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonWriter;
import jakarta.json.JsonWriterFactory;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.stream.JsonGenerator;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author palma
 */
public class JSONUtility {

    public static Object toObject(String json, Class clazz) {
        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(json, clazz);
    }

    public static String toJson(Object obj, boolean formatted) {
        Jsonb jsonb = JsonbBuilder.create();
        String jsonString= jsonb.toJson(obj);
        if (formatted) {
            StringReader sr = new StringReader(jsonString);
            StringWriter sw=new StringWriter();
            JsonReader reader = Json.createReader(sr);
            JsonObject jobj = reader.readObject();
            Map<String, Object> map = new HashMap<>();
            map.put(JsonGenerator.PRETTY_PRINTING, true);
            JsonWriterFactory writerFactory = Json.createWriterFactory(map);
            JsonWriter jsonWriter = writerFactory.createWriter(sw);
            jsonWriter.writeObject(jobj);
            jsonWriter.close();
            jsonString=sw.toString();
        }
        return jsonString;
    }
}
