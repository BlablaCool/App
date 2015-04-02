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
public class PlaceService extends ServiceInterface<Place,Integer>
{
    @Autowired
    private PlaceDao placeDao;

    @Override
    public Place findById(Integer integer)
    {
        return placeDao.findById(integer);
    }

    @Override
    public List<Place> findAll() {
        return placeDao.findAll();
    }

    @Override
    public void create(Place place) {
        placeDao.create(place);
    }

    @Override
    public void update(Place place) {
        placeDao.update(place);
    }

    @Override
    public void delete(Place place) {
        placeDao.delete(place);
    }

    @Override
    public void deleteById(Integer integer) {
        placeDao.deleteById(integer);
    }
}
