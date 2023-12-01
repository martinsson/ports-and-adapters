package com.schmeisky.apikata;

public class Observation {
    public String getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public String getDirection() {
        return direction;
    }

    private final String id;
    private final String stationName;
    private final String date;
    private final String time;
    private final float temperature;
    private final int pressure;
    private final String direction;

    public Observation(String id, String stationName, String date, String time, float temperature, int pressure, String direction) {
        this.id = id;
        this.stationName = stationName;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.pressure = pressure;
        this.direction = direction;
    }
}
