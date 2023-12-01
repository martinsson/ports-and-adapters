package com.schmeisky.apikata.domain;

import java.util.List;

public interface ObservationReader {
    List<Observation> readObservationsFor(String stationId);
}
