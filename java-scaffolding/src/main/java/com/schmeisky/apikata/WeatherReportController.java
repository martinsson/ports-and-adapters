package com.schmeisky.apikata;

import com.google.gson.Gson;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class WeatherReportController {

    public void put(String stationId) {
        try {
            final URL url = Path.of("example.json").toUri().toURL();
            try(InputStream inputStream = url.openStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            ) {
                final Gson gson = new Gson();
                final Result result = gson.fromJson(inputStreamReader, Result.class);
                try (FileWriter fileWriter = new FileWriter("result" + ".csv")) {
                    fileWriter.write("id,name,date,time,temperature,pressure,wind_direction\n" );
                    for (Map<String, Object> map : result.getResults()) {
                        String dateTime = (String) map.get("time");
                        var dateAndTime = dateTime.split(" ");
                        fileWriter.write(map.get("id") + "," + map.get("name") + "," + dateAndTime[0] + "," +dateAndTime[1] + "," + map.get("T") + "," + map.get("P") + "," + map.get("D") + "\n");
                    }
                }
                System.out.println(result);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("unable to parse URL", e);
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }

    }

    public static class Result {

        List<Map<String, Object>> results;

        public Result(final List<Map<String, Object>> results) {
            this.results = results;
        }

        public List<Map<String, Object>> getResults() {
            return results;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "results=" + results +
                    '}';
        }
    }

}
