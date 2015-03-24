package info.fges.blablacool.services;

import info.fges.blablacool.dao.SubscriptionDao;
import info.fges.blablacool.models.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class SubscriptionService extends ServiceInterface<Subscription,Integer>
{
    @Autowired
    private SubscriptionDao subscriptionDao;

    @Override
    public Subscription findById(Integer integer) {
        return subscriptionDao.findById(integer);
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionDao.findAll();
    }

    @Override
    public void create(Subscription trip) {
        subscriptionDao.create(trip);
    }

    @Override
    public void update(Subscription car)
    {
        subscriptionDao.update(car);
    }

    @Override
    public void delete(Subscription trip) {
        subscriptionDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        subscriptionDao.deleteById(integer);
    }
}
