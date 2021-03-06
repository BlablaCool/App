package info.fges.blablacool.services;

import info.fges.blablacool.dao.TripDao;
import info.fges.blablacool.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class TripService extends ServiceInterface<Trip,Integer> {
    @Autowired
    private TripDao tripDao;

    @Override
    public Trip findById(Integer integer) {
        return tripDao.findById(integer);
    }

    @Override
    public List<Trip> findAll() {
        return tripDao.findAll();
    }

    @Override
    public void create(Trip trip) {
        tripDao.create(trip);
    }

    @Override
    public void update(Trip trip) {
        tripDao.update(trip);
    }

    @Override
    public void delete(Trip trip) {
        tripDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        tripDao.deleteById(integer);
    }

    public List<Trip> findRecents()
    {
        return tripDao.findRecents();
    }

    public List<Trip> findRecentsWithFilters(HashMap<String, String> filters)
    {
        return tripDao.findRecentsWithFilters(filters);
    }
}
