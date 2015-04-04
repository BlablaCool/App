package info.fges.blablacool.dao;

import info.fges.blablacool.models.Trip;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Valentin on 02/04/15.
 */
@Repository
public class SearchDao
{
    @Autowired
    private SessionFactory sessionFactory;

    public List<Trip> findTripsWithAddresses(String _departureCity, String _arrivalCity, DateTime _departureTime)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Trip> tripList;
        Query query = session
                .createQuery("SELECT trip FROM Trip trip, Trip trip2\n" +
                        "INNER JOIN trip.steps AS step\n" +
                        "INNER JOIN trip2.steps AS step2\n" +
                        "WHERE DATE(step.estimatedTime) > DATE('1970-01-01') " +
                        "   AND ((step.position < trip.steps.size AND step.place.city LIKE :departureCity) \n" +
                        "   AND (step2.position = trip2.steps.size AND step2.place.city LIKE :arrivalCity))\n" +
                        "GROUP BY trip.id")
                .setParameter("departureCity", '%' + _departureCity + '%')
                .setParameter("arrivalCity", '%' + _arrivalCity + '%');
        tripList = query.list();

        transaction.commit();
        session.close();

        return tripList;
    }

    public List<Trip> findTripsNearbyLocation(BigDecimal _departureLatitude, BigDecimal _departureLongitude, String _arrivalCity, DateTime _departureTime)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Trip> tripList;
        Query query = session
                .createSQLQuery("SELECT t.* FROM trip t INNER JOIN step s ON t.id_trip = s.trip_id INNER JOIN place p on s.place_id = p.id_place CROSS JOIN trip t2 INNER JOIN step s2 ON t2.id_trip = s2.trip_id CROSS JOIN place p2 ON s2.place_id = p2.id_place WHERE p.id_place IN ( SELECT id_place FROM ( SELECT location, id_place, name_public, latitude, longitude, distance FROM ( SELECT z.id_place, z.name_public, z.latitude, z.longitude, z.location, p.radius, p.distance_unit * DEGREES(ACOS(COS(RADIANS(p.latpoint)) * COS(RADIANS(z.latitude)) * COS(RADIANS(p.longpoint - z.longitude)) + SIN(RADIANS(p.latpoint)) * SIN(RADIANS(z.latitude)))) AS distance FROM place AS z JOIN ( SELECT :latitude AS latpoint, :longitude AS longpoint, :perimeter AS radius, 111.045 AS distance_unit ) AS p ON 1=1 WHERE z.latitude BETWEEN p.latpoint - (p.radius / p.distance_unit) AND p.latpoint + (p.radius / p.distance_unit) AND z.longitude BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint)))) AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint)))) ) AS d WHERE distance <= radius ORDER BY distance LIMIT 15 ) geo ) AND s.position = 1 AND p2.city LIKE :arrivalCity GROUP BY t.id_trip")
                .addEntity(Trip.class)
                .setParameter("latitude", _departureLatitude)
                .setParameter("longitude", _departureLongitude)
                .setParameter("arrivalCity", '%' + _arrivalCity + '%')
                .setParameter("perimeter", 42.0);

        tripList = query.list();
        transaction.commit();
        session.close();

        return tripList;
    }
}
