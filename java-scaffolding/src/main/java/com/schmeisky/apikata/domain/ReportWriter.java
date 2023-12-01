package com.schmeisky.apikata.domain;

import java.util.List;

public interface ReportWriter {
    void write(String destination, List<String> lines);
}
