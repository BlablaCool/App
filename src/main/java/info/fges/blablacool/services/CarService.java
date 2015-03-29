package info.fges.blablacool.services;

import info.fges.blablacool.dao.CarDao;
import info.fges.blablacool.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class CarService extends ServiceInterface<Car,Integer>
{
    @Autowired
    private CarDao carDao;

    @Override
    public Car findById(Integer integer) {
        return carDao.findById(integer);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public void create(Car trip) {
        carDao.create(trip);
    }

    @Override
    public void update(Car car)
    {
        carDao.update(car);
    }

    @Override
    public void delete(Car trip) {
        carDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        carDao.deleteById(integer);
    }
}
