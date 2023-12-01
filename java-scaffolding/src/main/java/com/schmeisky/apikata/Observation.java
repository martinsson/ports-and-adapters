package com.schmeisky.apikata;

public class Observation {
    public Object getId() {
        return id;
    }

    public Object getStationName() {
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

    private final Object id;
    private final Object stationName;
    private final String date;
    private final String time;
    private final float temperature;
    private final int pressure;
    private final String direction;

    public Observation(Object id, Object stationName, String date, String time, float temperature, int pressure, String direction) {
        this.id = id;
        this.stationName = stationName;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.pressure = pressure;
        this.direction = direction;
    }
}
