package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.WeatherReportController;

public class Main {

        public static void main(final String[] args) {
            WeatherReportController weatherReportController = new WeatherReportController(new IcelandWeatherReader(), new FileReportWriter());
            weatherReportController.put(args[0]);
        }


}
