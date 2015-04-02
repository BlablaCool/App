package info.fges.blablacool.dao;

import info.fges.blablacool.models.Trip;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
                .setParameter("departureCity", '%' +_departureCity + '%')
                .setParameter("arrivalCity", '%' + _arrivalCity + '%');
        tripList = query.list();

        transaction.commit();
        session.close();

        return tripList;
    }
}
