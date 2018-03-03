package com.iss.rest;

import com.iss.domain.IssData;
import com.iss.domain.GeoLocalization;
import com.iss.helper.GlobalIpDetector;
import com.iss.service.GeoLocalizationService;
import com.iss.service.IssDataService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GeoLocalizationController {
    private GeoLocalizationService locationService;
    private IssDataService issDataService;

    public GeoLocalizationController(IssDataService issDataService) throws IOException {
        this.issDataService = issDataService;
        locationService = new GeoLocalizationService();
    }

    @GetMapping("/localization")
    public GeoLocalization getLocation() throws Exception {

        GlobalIpDetector globalIpDetector = new GlobalIpDetector();
        String ipAddress = globalIpDetector.getGlobalIp();

        return locationService.getLocation(ipAddress);
    }

    @GetMapping("/iss_position")
    public HttpEntity<IssData> getIssPosition() throws Exception {

        IssData issData = issDataService.getActualIssPosition();

        return ResponseEntity.ok(issData);
    }
}