package info.fges.blablacool.models;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Valentin on 02/04/15.
 */
@Component
public class Search
{
    @Resource()
    private SessionFactory sessionFactory;

    private SearchPoint departurePoint;
    private SearchPoint arrivalPoint;
    private DateTime departureTime;
    private Boolean withGeolocation;

    public DateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DateTime departureTime) {
        this.departureTime = departureTime;
    }

    public SearchPoint getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(SearchPoint departurePoint) {
        this.departurePoint = departurePoint;
    }

    public SearchPoint getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(SearchPoint arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public Search()
    {

    }

    public Search(SearchPoint _departurePoint, SearchPoint _arrivalPoint, DateTime _departureTime)
    {
        this.departurePoint = _departurePoint;
        this.arrivalPoint = _arrivalPoint;
        this.departureTime = _departureTime;
        this.withGeolocation = false;
    }

    public Search(SearchPoint _departurePoint, SearchPoint _arrivalPoint, DateTime _departureTime, Boolean _withGeolocation)
    {
        this.departurePoint = _departurePoint;
        this.arrivalPoint = _arrivalPoint;
        this.departureTime = _departureTime;
        this.withGeolocation = _withGeolocation;
    }
}
