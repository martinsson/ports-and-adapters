package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.ReportWriter;
import com.schmeisky.apikata.WeatherReader;
import com.schmeisky.apikata.WeatherReportController;

public class Main {

        public static void main(final String[] args) {
            WeatherReader weatherReader = new IcelandWeatherReader();
            ReportWriter reportWriter = new FileReportWriter();
            var weatherReportController = new WeatherReportController(weatherReader, reportWriter);
            weatherReportController.saveObservationsFor(args[0]);
        }


}
