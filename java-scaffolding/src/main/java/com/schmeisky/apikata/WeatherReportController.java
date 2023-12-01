package com.schmeisky.apikata;

public class WeatherReportController {

    private final WeatherReader weatherReader;
    private final ReportWriter reportWriter;

    public WeatherReportController(WeatherReader weatherReader, ReportWriter reportWriter) {
        this.weatherReader = weatherReader;
        this.reportWriter = reportWriter;
    }

    public void saveObservationsFor(String stationId) {
        var observations = weatherReader.readWeatherReport(stationId);
        var csvLines = ObservationCsvMapper.toCsv(observations);
        reportWriter.writeCsv(stationId, csvLines);
    }

}
