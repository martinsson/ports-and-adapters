package com.schmeisky.apikata;

import com.schmeisky.apikata.Observation;

import java.util.List;

public interface WeatherReader {
    List<Observation> readWeatherReport(String stationId);
}
