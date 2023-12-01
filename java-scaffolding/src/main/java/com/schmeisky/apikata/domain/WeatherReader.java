package com.schmeisky.apikata.domain;

import java.util.List;

public interface WeatherReader {
    List<Observation> readWeatherReport(String stationId);
}
