package info.fges.blablacool.dao;

import info.fges.blablacool.models.Subscription;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class SubscriptionDao extends DaoInterface<Subscription, Integer>
{
    @Override
    public Subscription findById(Integer integer)
    {
        openCurrentSession();
        Subscription subscription = (Subscription) currentSession.get(Subscription.class, integer);
        closeCurrentSession();

        return subscription;
    }

    @Override
    public List<Subscription> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Subscription");
        List<Subscription> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Subscription subscriptionToDelete = (Subscription) currentSession.get(Subscription.class, integer);
        currentSession.delete(subscriptionToDelete);
        closeCurrentSessionWithTransaction();
    }
}
