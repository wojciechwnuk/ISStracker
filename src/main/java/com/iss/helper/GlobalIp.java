package com.iss.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class GlobalIp {

    public String getGlobalIp() throws IOException {
        URL connection = new URL("http://checkip.amazonaws.com/");

        URLConnection con = connection.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        return reader.readLine();
    }
}
