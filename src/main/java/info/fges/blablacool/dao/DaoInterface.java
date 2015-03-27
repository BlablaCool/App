package info.fges.blablacool.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
public abstract class DaoInterface<T, Id extends Serializable>
{
    @Autowired
    SessionFactory sessionFactory;

    protected Session currentSession;
    protected Transaction currentTransaction;

    public Session openCurrentSession()
    {
        currentSession = sessionFactory.openSession();

        return currentSession;
    }

    public Session openCurrentSessionWithTransaction()
    {
        currentSession = sessionFactory.getCurrentSession();
        currentTransaction = currentSession.beginTransaction();

        return currentSession;
    }

    public void closeCurrentSession()
    {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction()
    {
        currentTransaction.commit();
        currentSession.close();
    }

    public abstract T findById(Id id);

    public abstract List<T> findAll();

    public abstract void deleteById(Id id);

    public void create(T obj)
    {
        openCurrentSessionWithTransaction().saveOrUpdate(obj);
        closeCurrentSessionWithTransaction();
    }

    public void update(T obj)
    {
        openCurrentSessionWithTransaction().update(obj);
        closeCurrentSessionWithTransaction();
    }

    public void delete(T obj)
    {
        openCurrentSessionWithTransaction().delete(obj);
        closeCurrentSessionWithTransaction();
    }
}