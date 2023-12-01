package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.WeatherReportController;
import com.schmeisky.apikata.infra.ReportWriter;
import com.schmeisky.apikata.infra.WeatherReader;

public class Main {

        public static void main(final String[] args) {
            WeatherReportController weatherReportController = new WeatherReportController(new WeatherReader(), new ReportWriter());
            weatherReportController.put(args[0]);
        }


}
