package com.pe.screenplaybdd.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class Utils {

    public JsonObject getJsonFile(String file) throws IOException {
        JsonObject jsonObject = null;
        JsonParser jsonParser = new JsonParser();

        try {
            Object obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") +
                    "/src/test/resources/request/" + file));
            jsonObject = (JsonObject) obj;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return jsonObject;
    }
}
