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
    @Override
    public Trip findById(Integer integer)
    {
        openCurrentSession();
        Trip trip = (Trip) currentSession.get(Trip.class, integer);
        closeCurrentSession();

        return trip;
    }

    @Override
    public List<Trip> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Trip");
        List<Trip> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Trip tripToDelete = (Trip) currentSession.get(Trip.class, integer);
        currentSession.delete(tripToDelete);
        closeCurrentSessionWithTransaction();
    }
}
