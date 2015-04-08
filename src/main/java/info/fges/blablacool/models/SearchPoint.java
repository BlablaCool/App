package info.fges.blablacool.models;

import org.json.simple.JSONObject;

import java.math.BigDecimal;

/**
 * Created by Valentin on 02/04/15.
 */
public class SearchPoint
{
    private String input;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String location;
    private String streetNumber;
    private String formattedAddress;
    private String postCode;
    private String city;
    private String country;
    private String state;
    private Boolean withGeolocation;

    public SearchPoint(JSONObject jsonObject)
    {
        this.input = (String) jsonObject.getOrDefault("name", "");
        this.location = (String) jsonObject.getOrDefault("location", "");
        this.streetNumber = (String) jsonObject.getOrDefault("street_number", "");
        this.formattedAddress = (String) jsonObject.getOrDefault("formatted_address", "");
        this.postCode = (String) jsonObject.getOrDefault("postal_code", "");
        this.city = (String) jsonObject.getOrDefault("locality", "");
        this.country = (String) jsonObject.getOrDefault("country", "");
        this.state = (String) jsonObject.getOrDefault("administrative_area_level_1", "");
        this.withGeolocation = false;

        if (jsonObject.containsKey("lat") && !((String) jsonObject.get("lat")).contentEquals(""))
            this.latitude = new BigDecimal((String) jsonObject.get("lat"));
        else
            this.latitude = new BigDecimal(0.0);

        if (jsonObject.containsKey("lng") && !((String) jsonObject.get("lng")).contentEquals(""))
            this.longitude = new BigDecimal((String) jsonObject.get("lng"));
        else
            this.longitude = new BigDecimal(0.0);
     }

    public SearchPoint(String _latitude, String _longitude)
    {
        this.latitude = new BigDecimal(_latitude);
        this.longitude = new BigDecimal(_longitude);
        this.withGeolocation = true;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
