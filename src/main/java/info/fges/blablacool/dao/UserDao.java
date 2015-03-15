package info.fges.blablacool.dao;

import info.fges.blablacool.models.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class UserDao extends DaoInterface<User, Integer>
{
    @Override
    public User findById(Integer integer)
    {
        openCurrentSession();
        User user = (User) currentSession.get(User.class, integer);
        closeCurrentSession();

        return user;
    }

    @Override
    public List<User> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from User");
        List<User> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        User userToDelete = (User) currentSession.get(User.class, integer);
        currentSession.delete(userToDelete);
        closeCurrentSessionWithTransaction();
    }
}
