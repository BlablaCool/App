package info.fges.blablacool.dao;

import info.fges.blablacool.models.Place;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class PlaceDao extends DaoInterface<Place, Integer>
{
    @Override
    public Place findById(Integer integer)
    {
        openCurrentSession();
        Place place = (Place) currentSession.get(Place.class, integer);
        closeCurrentSession();

        return place;
    }

    @Override
    public List<Place> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Place");
        List<Place> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Place placeToDelete = (Place) currentSession.get(Place.class, integer);
        currentSession.delete(placeToDelete);
        closeCurrentSessionWithTransaction();
    }
}
