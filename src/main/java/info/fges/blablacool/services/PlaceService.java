package info.fges.blablacool.services;

import info.fges.blablacool.dao.PlaceDao;
import info.fges.blablacool.models.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class PlaceService extends ServiceInterface<Place,Integer> {
    @Autowired
    private PlaceDao placeDao;

    @Override
    public Place findById(Integer integer) {
        return placeDao.findById(integer);
    }

    @Override
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    @Override
    public void create(Place trip) {
        placeDao.create(trip);
    }

    @Override
    public void delete(Place trip) {
        placeDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        placeDao.deleteById(integer);
    }
}
