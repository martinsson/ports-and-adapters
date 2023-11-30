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
        Assertions.assertThat(new File("result.csv")).exists();
    }

    @Test
    void hasAllTheData() throws Exception {
        var expectedColumns = "id,name,date,time,temperature,pressure,wind_direction";

        new WeatherReportController().put(stationId);

        String content = Files.readString(Paths.get("result.csv"));
        Assertions.assertThat(content).startsWith(expectedColumns);
    }

    @Test
    void hasSomeContent() throws IOException {
        new WeatherReportController().put(stationId);
        var content = Files.readAllLines(Paths.get("result.csv"));
        Assertions.assertThat(content).hasSizeGreaterThan(1);
        Assertions.assertThat(content.get(1)).matches("1,Reykjavík,.*,.*,.*,.*,.*");
    }

    @Test
    void sandbox() {

        var text = "{\"results\":[{\"name\":\"Reykjavík\",\"time\":\"2023-11-30 21:00:00\",\"err\":\"\",\"link\":\"http://en.vedur.is/weather/observations/areas/reykjavik/#group=100&station=1\",\"F\":\"6\",\"FX\":\"8\",\"FG\":\"13\",\"D\":\"NNE\",\"T\":\"-0.8\",\"W\":\"Light snow\",\"V\":\"12\",\"N\":\"100\",\"P\":\"1029\",\"RH\":\"80\",\"SNC\":\"\",\"SND\":\"\",\"SED\":\"\",\"RTE\":\"\",\"TD\":\"-3.8\",\"R\":\"0.1\",\"id\":\"1\",\"valid\":\"1\"}]}";
        final Gson gson = new Gson();
        final WeatherReportController.Result result = gson.fromJson(text, WeatherReportController.Result.class);
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