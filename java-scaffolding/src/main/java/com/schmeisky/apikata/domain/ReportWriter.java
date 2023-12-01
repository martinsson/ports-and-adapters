package com.schmeisky.apikata.domain;

import java.util.List;

public interface ReportWriter {
    void writeCsv(String stationId, List<String> csvLines);
}
