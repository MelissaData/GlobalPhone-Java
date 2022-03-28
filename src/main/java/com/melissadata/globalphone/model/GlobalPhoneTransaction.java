package com.melissadata.globalphone.model;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GlobalPhoneTransaction {
    private final String endpoint;
    private GlobalPhoneOptions options;
    private String identNumber;
    private String phone;
    private String country;
    private String countryOrigin;

    public GlobalPhoneTransaction(){
        endpoint      = "https://globalphone.melissadata.net/v4/WEB/GlobalPhone/doGlobalPhone?";
        options       = new GlobalPhoneOptions();
        identNumber   = "";
        phone         = "";
        country       = "";
        countryOrigin = "";
    }

    public String processTransaction(String request) {
        String response = "";
        try {
            URL url = new URL(request);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String responseBody = in.lines().collect(Collectors.joining());
            response = getPrettyJSON(responseBody);

        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    private String getPrettyJSON(String json) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject responseObject = gson.fromJson(json, JsonObject.class);
        return gson.toJson(responseObject);
    }

    public String generateRequestString() {
        String request = "";
        request = endpoint;
        request += "&id=" + getIdentNumber();
        request += "&opt=" + options.generateOptionString();
        try {
            if(!getPhone().equals(""))
                request += "&phone=" + URLEncoder.encode(getPhone(), "UTF-8");

            if(!getCountry().equals(""))
                request += "&ctry=" + URLEncoder.encode(getCountry(), "UTF-8");

            if(!getCountryOrigin().equals(""))
                request += "&ctryOrg=" + URLEncoder.encode(getCountryOrigin(), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " +e);
        }

        return request;
    }

    public GlobalPhoneOptions getOptions() {
        return options;
    }

    public void setOptions(GlobalPhoneOptions options) {
        this.options = options;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }
}
