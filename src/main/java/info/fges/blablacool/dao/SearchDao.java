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

    public List<Trip> findTrips(String _departurePointJson, String _arrivalPointJson, String _infosJson)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Trip> tripList;
        Query query = session
                .createQuery("FROM Trip")
                .setMaxResults(20);
        tripList = query.list();

        transaction.commit();
        session.close();

        return tripList;
    }

    public List<Trip> findTripsWithAddresses(String _departureCity, String _arrivalCity, DateTime _departureTime)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Trip> tripList;
        Query query = session
                .createQuery("FROM Trip trip, Trip trip2\n" +
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
                .createSQLQuery("SELECT t.* FROM trip t INNER JOIN step s ON t.id_trip = s.trip_id INNER JOIN place p on s.place_id = p.id_place WHERE p.id_place IN ( SELECT id_place FROM ( SELECT location, id_place, name_public, latitude, longitude, distance FROM ( SELECT z.id_place, z.name_public, z.latitude, z.longitude, z.location, p.radius, p.distance_unit * DEGREES(ACOS(COS(RADIANS(p.latpoint)) * COS(RADIANS(z.latitude)) * COS(RADIANS(p.longpoint - z.longitude)) + SIN(RADIANS(p.latpoint)) * SIN(RADIANS(z.latitude)))) AS distance FROM place AS z JOIN ( SELECT :latitude AS latpoint, :longitude AS longpoint, :perimeter AS radius, 111.045 AS distance_unit ) AS p ON 1=1 WHERE z.latitude BETWEEN p.latpoint - (p.radius / p.distance_unit) AND p.latpoint + (p.radius / p.distance_unit) AND z.longitude BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint)))) AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint)))) ) AS d WHERE distance <= radius ORDER BY distance LIMIT 15 ) geo )")
                .addEntity(Trip.class)
                .setParameter("latitude", _departureLatitude)
                .setParameter("longitude", _departureLongitude)
                .setParameter("perimeter", 42.0);

        tripList = query.list();
        transaction.commit();
        session.close();

        return tripList;

//        SELECT trip0_.id_trip         AS id_trip1_6_0_,
//            steps2_.id_step        AS id_step1_4_1_,
//        trip1_.id_trip         AS id_trip1_6_2_,
//            steps3_.id_step        AS id_step1_4_3_,
//        trip0_.animals         AS animals2_6_0_,
//            trip0_.smoking         AS smoking3_6_0_,
//        trip0_.capacity        AS capacity4_6_0_,
//            trip0_.driver_id       AS driver_i7_6_0_,
//        trip0_.luggage         AS luggage5_6_0_,
//            trip0_.price           AS price6_6_0_,
//        steps2_.estimated_time AS estimate2_4_1_,
//            steps2_.place_id       AS place_id4_4_1_,
//        steps2_.position       AS position3_4_1_,
//            steps2_.trip_id        AS trip_id5_4_1_,
//        trip1_.animals         AS animals2_6_2_,
//            trip1_.smoking         AS smoking3_6_2_,
//        trip1_.capacity        AS capacity4_6_2_,
//            trip1_.driver_id       AS driver_i7_6_2_,
//        trip1_.luggage         AS luggage5_6_2_,
//            trip1_.price           AS price6_6_2_,
//        steps3_.estimated_time AS estimate2_4_3_,
//            steps3_.place_id       AS place_id4_4_3_,
//        steps3_.position       AS position3_4_3_,
//            steps3_.trip_id        AS trip_id5_4_3_
//        FROM   trip trip0_
//        INNER JOIN step steps2_
//        ON trip0_.id_trip = steps2_.trip_id
//        CROSS JOIN trip trip1_
//        INNER JOIN step steps3_
//        ON trip1_.id_trip = steps3_.trip_id
//        CROSS JOIN place place5_
//        CROSS JOIN place place7_
//        WHERE  steps2_.place_id = place5_.id_place
//        AND steps3_.place_id = place7_.id_place
//        AND Date(steps2_.estimated_time) > Date('1970-01-01')
//        AND steps2_.position < (SELECT Count(steps4_.trip_id)
//        FROM   step steps4_
//        WHERE  trip0_.id_trip = steps4_.trip_id)
//        AND ( place5_.id_place IN (SELECT id_place
//                FROM   (SELECT location,
//                        id_place,
//                        name_public,
//                        latitude,
//                        longitude,
//                        distance
//                        FROM   (SELECT z.id_place,
//                                z.name_public,
//                                z.latitude,
//                                z.longitude,
//                                z.location,
//                                p.radius,
//                                p.distance_unit *
//                                        Degrees(Acos(Cos(Radians(p.latpoint))
//                                                * Cos(
//                                                Radians(z.latitude)) *
//                                                Cos(
//                                                        Radians(p.longpoint
//                                                                - z.longitude)) +
//                                                Sin(
//                                                        Radians(p.latpoint)) *
//                                                        Sin(
//                                                                Radians(z.latitude)))) AS
//                                distance
//                                FROM   place AS z
//                                JOIN (SELECT 50.70   AS latpoint,
//        1.57    AS longpoint,
//        30.0    AS radius,
//        111.045 AS distance_unit) AS p
//        ON 1 = 1
//        WHERE  z.latitude BETWEEN p.latpoint - (
//            p.radius / p.distance_unit )
//        AND
//        p.latpoint +
//                (
//                        p.radius / p.distance_unit )
//        AND z.longitude BETWEEN p.longpoint - (
//            p.radius / ( p.distance_unit *
//                    Cos(
//                            Radians(p.latpoint)) ) )
//        AND
//        p.longpoint + ( p.radius / ( p.distance_unit *
//                Cos(
//                        Radians(p.latpoint)) ) )) AS d
//        WHERE  distance <= radius
//        ORDER  BY distance
//        LIMIT  15) geo) )
//        AND steps3_.position = (SELECT Count(steps6_.trip_id)
//        FROM   step steps6_
//        WHERE  trip1_.id_trip = steps6_.trip_id)
//        AND ( place7_.city LIKE '%Lille%' )
//        GROUP  BY trip0_.id_trip
    }
}
