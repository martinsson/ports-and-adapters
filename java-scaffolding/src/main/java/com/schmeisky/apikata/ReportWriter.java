package com.schmeisky.apikata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriter {
    void writeCsvFile(String stationId, List<String> csvLines) {
        try (FileWriter fileWriter = new FileWriter(stationId + ".csv")) {
            for (String line : csvLines) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }
    }
}