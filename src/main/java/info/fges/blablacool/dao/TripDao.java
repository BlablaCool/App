package info.fges.blablacool.dao;

import info.fges.blablacool.models.Trip;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class TripDao extends DaoInterface<Trip, Integer>
{
    /**
     * Finds trip by id
     * @param integer
     * @return
     */
    @Override
    public Trip findById(Integer integer)
    {
        openCurrentSession();
        Trip trip = (Trip) currentSession.get(Trip.class, integer);
        closeCurrentSession();

        return trip;
    }

    /**
     * Finds all trips
     * @return
     */
    @Override
    public List<Trip> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Trip");
        List<Trip> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * Deletes trip by id
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Trip tripToDelete = (Trip) currentSession.get(Trip.class, integer);
        currentSession.delete(tripToDelete);
        closeCurrentSessionWithTransaction();
    }

    /**
     * finds last trips
     * @return
     */
    public List<Trip> findRecents()
    {
        List<Trip> tripList;

        openCurrentSession();
        Query query = currentSession
                .createQuery("FROM Trip ORDER BY idTrip DESC")
                .setMaxResults(20);
        tripList = query.list();
        closeCurrentSession();

        return tripList;
    }
}
