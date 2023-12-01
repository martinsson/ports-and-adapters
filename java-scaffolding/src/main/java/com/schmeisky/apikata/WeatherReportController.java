package com.schmeisky.apikata;

import java.util.ArrayList;
import java.util.List;

public class WeatherReportController {

    private final WeatherReader weatherReader;
    private final ReportWriter reportWriter;

    public WeatherReportController(WeatherReader weatherReader, ReportWriter reportWriter) {
        this.weatherReader = weatherReader;
        this.reportWriter = reportWriter;
    }

    public void saveObservationsFor(String stationId) {
        var observations = weatherReader.readWeatherReport(stationId);
        var csvLines = computeWeatherReport(observations);
        reportWriter.writeCsv(stationId, csvLines);
    }

    private static ArrayList<String> computeWeatherReport(List<Observation> observations) {
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
