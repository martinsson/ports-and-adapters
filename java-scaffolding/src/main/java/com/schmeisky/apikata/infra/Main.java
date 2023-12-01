package com.schmeisky.apikata.infra;

import com.schmeisky.apikata.domain.ReportWriter;
import com.schmeisky.apikata.domain.ObservationReader;
import com.schmeisky.apikata.domain.SaveReportService;

public class Main {

        public static void main(final String[] args) {
            ObservationReader weatherReader = new IcelandObservationsReader();
            ReportWriter reportWriter = new FileReportWriter();
            var weatherReportController = new SaveReportService(weatherReader, reportWriter);
            weatherReportController.saveObservationsFor(args[0]);
        }


}
