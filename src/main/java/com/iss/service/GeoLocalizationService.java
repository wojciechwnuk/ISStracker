package com.iss.service;

import com.iss.domain.GeoLocalization;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoLocalizationService {

    private DatabaseReader dbReader;

    public GeoLocalizationService() throws IOException {
        File database = new File("src/main/resources/GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public GeoLocalization getLocation(String ip) throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude = response.getLocation().getLatitude().toString();
        String longitude = response.getLocation().getLongitude().toString();

        return new GeoLocalization(ip, cityName, latitude, longitude);
    }


}
