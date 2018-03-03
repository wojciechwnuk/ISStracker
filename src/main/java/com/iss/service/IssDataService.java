package com.iss.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iss.domain.IssData;

import java.io.IOException;
import java.net.URL;

public class IssDataService {

    private final String url = "http://api.open-notify.org/iss-now.json";

    public IssData getActualIssPosition() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(new URL(url), IssData.class);
    }
}
