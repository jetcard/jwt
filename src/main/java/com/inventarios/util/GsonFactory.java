package com.inventarios.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
public class GsonFactory {
    public static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setDateFormat("yyyy-MM-dd")
                .create();
    }
}