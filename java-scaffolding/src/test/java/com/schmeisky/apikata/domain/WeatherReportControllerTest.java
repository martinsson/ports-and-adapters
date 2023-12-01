package com.schmeisky.apikata.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeatherReportControllerTest {

    @Test
    void name() {
        FakeReportWriter reportWriter = new FakeReportWriter();
        FakeWeatherReader weatherReader = new FakeWeatherReader();
        weatherReader.registerObservation(new Observation("1", "Reykjavík", "2020-01-01", "12:00", 10.0f, 1000, "N"));
        WeatherReportController weatherReportController = new WeatherReportController(weatherReader, reportWriter);
        weatherReportController.saveObservationsFor("1");
        Assertions.assertThat(reportWriter.getContentFor("1")).isEqualTo("id,name,date,time,temperature,pressure,wind_direction\n" +
                                                                         "1,Reykjavík,2020-01-01,12:00,10.0,1000,N");
    }
}