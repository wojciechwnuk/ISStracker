package com.iss.rest;

import com.iss.domain.GeoIP;
import com.iss.service.GeoLocalizationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GeoIPTestController {
    private GeoLocalizationService locationService;

    public GeoIPTestController() throws IOException {
        locationService = new GeoLocalizationService();
    }

    @PostMapping("/GeoIPTest")
    public GeoIP getLocation(@RequestParam String ipAddress) throws Exception {

        return locationService.getLocation(ipAddress);
    }
}