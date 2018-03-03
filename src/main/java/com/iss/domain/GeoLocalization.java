package com.iss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeoLocalization {

    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
}
