package com.schmeisky.apikata.domain;

import java.util.ArrayList;
import java.util.List;

public class CsvMapper {
    public static ArrayList<String> toCsv(List<Observation> observations) {
        var csvLines = new ArrayList<String>();
        csvLines.add("id,name,date,time,temperature,pressure,wind_direction");
        for (Observation o : observations) {
            String s = o.getId() + "," +
                       o.getStationName() + "," +
                       o.getDate() + "," +
                       o.getTime() + "," +
                       o.getTemperature() + "," +
                       o.getPressure() + "," +
                       o.getDirection();
            csvLines.add(s);
        }
        return csvLines;
    }
}