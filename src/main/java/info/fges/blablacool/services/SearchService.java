package info.fges.blablacool.services;

import info.fges.blablacool.dao.SearchDao;
import info.fges.blablacool.models.Search;
import info.fges.blablacool.models.SearchPoint;
import info.fges.blablacool.models.Trip;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by Valentin on 02/04/15.
 */
@Service
public class SearchService
{
    @Autowired
    private SearchDao searchDao;

    public String getSearchUrlForTripsWithAddresses(String _departurePointJson, String _arrivalPointJson, String _infosJson)
    {
        JSONObject jsonObjectInfos = (JSONObject) JSONValue.parse(_infosJson);
        DateTime departureDateTime = DateTime.parse((String) jsonObjectInfos.get("departureTime"), DateTimeFormat.forPattern("dd/MM/yyyy"));

        SearchPoint departureSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_departurePointJson));
        SearchPoint arrivalSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_arrivalPointJson));

        return "/search/" + URLEncoder.encode(departureSearchPoint.getCity()) + "/"
                + URLEncoder.encode(arrivalSearchPoint.getCity()) + "/"
                + departureDateTime.toString("dd-MM-yyyy");
    }

    public String getSearchUrlForTripsNearbyLocation(String _departureGeolocationJson, String _arrivalPointJson, String _infosJson)
    {
        // Infos about trip
        JSONObject jsonObjectInfos = (JSONObject) JSONValue.parse(_infosJson);
        DateTime departureDateTime = DateTime.parse((String) jsonObjectInfos.get("departureTime"), DateTimeFormat.forPattern("dd/MM/yyyy"));

        // Departure point with Geolocation
        JSONObject jsonObjectGeolocation = (JSONObject) JSONValue.parse(_departureGeolocationJson);
        SearchPoint departureSearchPoint = new SearchPoint((String) jsonObjectGeolocation.get("latitude"), (String) jsonObjectGeolocation.get("longitude"));

        // Arrival point with geolocation
        SearchPoint arrivalSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_arrivalPointJson));

        return "/search/" + URLEncoder.encode(departureSearchPoint.getLatitude().toString()) + "/" +
                URLEncoder.encode(departureSearchPoint.getLongitude().toString()) + "/" +
                URLEncoder.encode(arrivalSearchPoint.getCity()) + "/" +
                departureDateTime.toString("dd-MM-yyyy");
    }

    public List<Trip> findTripsWithAddresses(String departureCity, String arrivalCity, String departureTimeAsString)
    {
        DateTime departureDateTime = DateTime.parse(departureTimeAsString, DateTimeFormat.forPattern("dd-MM-yyyy"));

        return searchDao.findTripsWithAddresses(departureCity, arrivalCity, departureDateTime);
    }

    public List<Trip> findTripsNearbyLocation(BigDecimal departureLatitude, BigDecimal departureLongitude, String arrivalCity, String departureTimeAsString)
    {
        DateTime departureDateTime = DateTime.parse(departureTimeAsString, DateTimeFormat.forPattern("dd-MM-yyyy"));

        return searchDao.findTripsNearbyLocation(departureLatitude, departureLongitude, arrivalCity, departureDateTime);
    }
}
