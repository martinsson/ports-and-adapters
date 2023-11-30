package com.schmeisky.apikata;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;

import java.nio.charset.Charset;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Main {

        public static void main(final String[] args) {
            new WeatherReportController().put(args[0]);
        }


}
