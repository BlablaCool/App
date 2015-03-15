package info.fges.blablacool.dao;

import info.fges.blablacool.models.Car;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class CarDao extends DaoInterface<Car, Integer>
{
    @Override
    public Car findById(Integer integer)
    {
        openCurrentSession();
        Car car = (Car) currentSession.get(Car.class, integer);
        closeCurrentSession();

        return car;
    }

    @Override
    public List<Car> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Car");
        List<Car> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Car carToDelete = (Car) currentSession.get(Car.class, integer);
        currentSession.delete(carToDelete);
        closeCurrentSessionWithTransaction();
    }
}
