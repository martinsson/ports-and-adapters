package com.schmeisky.apikata.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FakeReportWriter implements ReportWriter {
    private Map<String, List<String>> results = new HashMap<>();

    @Override
    public void write(String destination, List<String> lines) {
        this.results.put(destination, lines);
    }

    public String getContentFor(String number) {
        return results.get(number).stream().collect(Collectors.joining("\n"));
    }
}
