package com.schmeisky.apikata.domain;

public class SaveReportService {

    private final ObservationReader weatherReader;
    private final ReportWriter reportWriter;

    public SaveReportService(ObservationReader weatherReader, ReportWriter reportWriter) {
        this.weatherReader = weatherReader;
        this.reportWriter = reportWriter;
    }

    public void saveObservationsFor(String stationId) {
        var observations = weatherReader.readObservationsFor(stationId);
        var csvLines = CsvMapper.toCsv(observations);
        reportWriter.write(stationId, csvLines);
    }

}
