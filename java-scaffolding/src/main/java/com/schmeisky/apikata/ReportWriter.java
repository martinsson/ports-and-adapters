package com.schmeisky.apikata;

import java.util.List;

public interface ReportWriter {
    void writeCsv(String stationId, List<String> csvLines);
}
