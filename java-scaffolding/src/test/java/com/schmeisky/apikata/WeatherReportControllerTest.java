package com.schmeisky.apikata;

import com.schmeisky.apikata.infra.FileReportWriter;
import com.schmeisky.apikata.infra.IcelandWeatherReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class WeatherReportControllerTest {

    private final String stationId = "1";

    @Test
    void savesTheReportAsCsv() {
        new WeatherReportController(new IcelandWeatherReader(), new FileReportWriter()).put(stationId);
        Assertions.assertThat(new File(stationId + ".csv")).exists();
    }

    @Test
    void hasAllTheData() throws Exception {
        var expectedColumns = "id,name,date,time,temperature,pressure,wind_direction";

        new WeatherReportController(new IcelandWeatherReader(), new FileReportWriter()).put(stationId);

        String content = Files.readString(Paths.get(stationId + ".csv"));
        Assertions.assertThat(content).startsWith(expectedColumns);
    }

    @Test
    void hasSomeContent() throws IOException {
        new WeatherReportController(new IcelandWeatherReader(), new FileReportWriter()).put(stationId);
        var content = Files.readAllLines(Paths.get(stationId + ".csv"));
        Assertions.assertThat(content).hasSizeGreaterThan(1);
        Assertions.assertThat(content.get(1)).matches("1,Reykjavík,.*,.*,.*,.*,.*");
    }


    @ParameterizedTest
    @CsvSource(textBlock =
//            "1,Reykjavík,2023-11-30,21:00:00,-0.8,1029,NNE 1,Reykjavik,.*,.*,.*,.*,.\n" +
//            "1,Reykjavík,2023-11-30,21:00:00 1,Reykjavik,.*,.*\n" +
//            "1,Reykjavík 1,Reykjavik\n" +
            "1,Reykjavík 1,Reykjavík\n" +
            "1,1 1,1"
            , delimiter = ' ')
    void sbox2(String str, String pattern) {
        Assertions.assertThat(str).matches(pattern);
    }
}