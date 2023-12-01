package com.schmeisky.apikata;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WeatherReader {
    List<Observation> readWeatherReport(String stationId) {
        final URL url = obtainUrl(stationId);

        final Result result = doRequest(url);

        return result.getResults().stream().map(WeatherReader::toObservation).collect(toList());
    }

    private static Result doRequest(URL url) {
        try (InputStream inputStream = url.openStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)
        ) {
            final Gson gson = new Gson();
            return gson.fromJson(inputStreamReader, Result.class);
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }
    }

    private static URL obtainUrl(String stationId) {
        try {
            return new URL("https://apis.is/weather/observations/en?stations=" + stationId);
        } catch (MalformedURLException e) {
            throw new RuntimeException("unable to parse URL", e);
        }
    }

    private static Observation toObservation(Map<String, String> map) {
        String dateTime = map.get("time");
        var dateAndTime = dateTime.split(" ");
        return new Observation(
                map.get("id"),
                map.get("name"),
                dateAndTime[0],
                dateAndTime[1],
                Float.parseFloat(map.get("T")),
                Integer.parseInt(map.get("P")),
                map.get("D"));
    }

    static class Result {

        List<Map<String, String>> results;

        public Result(final List<Map<String, String>> results) {
            this.results = results;
        }

        public List<Map<String, String>> getResults() {
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