package melissadata.globalphone.model;

import org.apache.sling.commons.json.JSONObject;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

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
        URI uri;
        URL url;
        try {
            uri = new URI(request);
            url = new URL(uri.toURL().toString());

            HttpURLConnection urlConn = (HttpURLConnection)(url.openConnection());

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuilder jsonResponse = new StringBuilder();
            String inputLine = "";

            while ((inputLine = in.readLine()) != null) {
                jsonResponse.append(inputLine);
            }
            @SuppressWarnings("deprecation")
            JSONObject test = new JSONObject(jsonResponse.toString());
            response = test.toString(10);

        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
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
