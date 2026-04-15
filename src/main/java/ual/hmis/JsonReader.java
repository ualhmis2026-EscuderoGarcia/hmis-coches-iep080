package ual.hmis;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class JsonReader {

    public static Coche[] leerCochesJSON(String archivo) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(archivo)) {
            JsonArray cochesJson = JsonParser.parseReader(reader).getAsJsonArray();
            return gson.fromJson(cochesJson, Coche[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}