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

import java.util.List;

/**
 * Created by Valentin on 02/04/15.
 */
@Service
public class SearchService
{
    @Autowired
    private SearchDao searchDao;

    public List<Trip> findTripsWithAddresses(String _departurePointJson, String _arrivalPointJson, String _infosJson)
    {
        JSONObject jsonObjectInfos = (JSONObject) JSONValue.parse(_infosJson);
        DateTime departureDateTime = DateTime.parse((String) jsonObjectInfos.get("departureTime"), DateTimeFormat.forPattern("dd/MM/yyyy"));

        SearchPoint departureSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_departurePointJson));
        SearchPoint arrivalSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_arrivalPointJson));

        Search search = new Search(departureSearchPoint, arrivalSearchPoint, departureDateTime);

        return searchDao.findTripsWithAddresses(search.getDeparturePoint().getCity(),
                search.getArrivalPoint().getCity(),
                search.getDepartureTime());
    }

    public List<Trip> findTripsNearbyLocation(String _departureGeolocationJson, String _arrivalPointJson, String _infosJson)
    {
        // Infos about trip
        JSONObject jsonObjectInfos = (JSONObject) JSONValue.parse(_infosJson);
        DateTime departureDateTime = DateTime.parse((String) jsonObjectInfos.get("departureTime"), DateTimeFormat.forPattern("dd/MM/yyyy"));

        // Departure point with Geolocation
        JSONObject jsonObjectGeolocation = (JSONObject) JSONValue.parse(_departureGeolocationJson);
        SearchPoint departureSearchPoint = new SearchPoint((String) jsonObjectGeolocation.get("latitude"), (String) jsonObjectGeolocation.get("longitude"));

        // Arrival point with geolocation
        SearchPoint arrivalSearchPoint = new SearchPoint((JSONObject) JSONValue.parse(_arrivalPointJson));

        // Global search
        Search search = new Search(departureSearchPoint, arrivalSearchPoint, departureDateTime);

        return searchDao.findTripsNearbyLocation(search.getDeparturePoint().getLatitude(),
                search.getDeparturePoint().getLongitude(),
                search.getArrivalPoint().getCity(),
                search.getDepartureTime());
    }
}
