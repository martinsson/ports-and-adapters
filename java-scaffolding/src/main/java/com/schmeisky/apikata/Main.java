package com.schmeisky.apikata;

public class Main {

        public static void main(final String[] args) {
            WeatherReportController weatherReportController = new WeatherReportController(new WeatherReader(), new ReportWriter());
            weatherReportController.put(args[0]);
        }


}
