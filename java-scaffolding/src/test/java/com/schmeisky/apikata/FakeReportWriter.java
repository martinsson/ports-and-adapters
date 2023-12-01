package com.schmeisky.apikata;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FakeReportWriter implements ReportWriter {
    private Map<String, List<String>> results = new HashMap<>();

    @Override
    public void writeCsv(String stationId, List<String> csvLines) {
        this.results.put(stationId, csvLines);
    }

    public String getContentFor(String number) {
        return results.get(number).stream().collect(Collectors.joining("\n"));
    }
}
