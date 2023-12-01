package com.schmeisky.apikata;

import com.google.gson.Gson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class WeatherReportControllerTest {

    private final String stationId = "1";

    @Test
    void savesTheReportAsCsv() {
        new WeatherReportController().put(stationId);
        Assertions.assertThat(new File(stationId + ".csv")).exists();
    }

    @Test
    void hasAllTheData() throws Exception {
        var expectedColumns = "id,name,date,time,temperature,pressure,wind_direction";

        new WeatherReportController().put(stationId);

        String content = Files.readString(Paths.get(stationId + ".csv"));
        Assertions.assertThat(content).startsWith(expectedColumns);
    }

    @Test
    void hasSomeContent() throws IOException {
        new WeatherReportController().put(stationId);
        var content = Files.readAllLines(Paths.get(stationId + ".csv"));
        Assertions.assertThat(content).hasSizeGreaterThan(1);
        Assertions.assertThat(content.get(1)).matches("1,Reykjavik,.*,.*,.*,.*,.*");
    }

}