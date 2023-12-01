package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.domain.SaveReportService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class SystemTest {

    private final String stationId = "1";

    @Test
    void savesTheReportAsCsv() {
        new SaveReportService(new IcelandObservationsReader(), new FileReportWriter()).saveObservationsFor(stationId);
        Assertions.assertThat(new File(stationId + ".csv")).exists();
    }

    @Test
    void hasAllTheData() throws Exception {
        var expectedColumns = "id,name,date,time,temperature,pressure,wind_direction";

        new SaveReportService(new IcelandObservationsReader(), new FileReportWriter()).saveObservationsFor(stationId);

        String content = Files.readString(Paths.get(stationId + ".csv"));
        Assertions.assertThat(content).startsWith(expectedColumns);
    }

    @Test
    void hasSomeContent() throws IOException {
        new SaveReportService(new IcelandObservationsReader(), new FileReportWriter()).saveObservationsFor(stationId);
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