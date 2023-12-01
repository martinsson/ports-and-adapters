package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.domain.ReportWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileReportWriter implements ReportWriter {
     @Override
     public void write(String destination, List<String> lines) {
        try (FileWriter fileWriter = new FileWriter(destination + ".csv")) {
            for (String line : lines) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }
    }
}