package com.iss.rest;

import com.iss.domain.GeoIP;
import com.iss.helper.GlobalIp;
import com.iss.service.GeoLocalizationService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GeoIPTestController {
    private GeoLocalizationService locationService;

    public GeoIPTestController() throws IOException {
        locationService = new GeoLocalizationService();
    }

    @GetMapping("/GeoIPTest")
    public GeoIP getLocation() throws Exception {

        GlobalIp globalIp = new GlobalIp();
        String ipAddress = globalIp.getGlobalIp();

        return locationService.getLocation(ipAddress);
    }
}