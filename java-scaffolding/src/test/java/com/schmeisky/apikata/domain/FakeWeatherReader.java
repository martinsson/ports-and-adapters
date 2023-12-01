package com.schmeisky.apikata.domain;

import java.util.ArrayList;
import java.util.List;

public class FakeWeatherReader implements WeatherReader {
    private final List<Observation> observations = new ArrayList<>();
    @Override
    public List<Observation> readWeatherReport(String stationId) {
        return observations;
    }

    public void registerObservation(Observation observation) {
        observations.add(observation);
    }
}
