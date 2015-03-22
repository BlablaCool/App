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
    public User findByEmail(String email)
    {
        User user = null;

        Query query = openCurrentSession()
                .createQuery("from User where email = :email")
                .setParameter("email", email)
                .setMaxResults(1);

        if (query.list().size() > 0)
            user = (User) query.list().get(0);

        closeCurrentSession();

        return user;
    }

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

    public boolean nicknameAlreadyExists(String nickname)
    {
        boolean nicknameExists = false;

        Query query = openCurrentSession()
                .createQuery("from User where nickname = :nickname")
                .setParameter("nickname", nickname)
                .setMaxResults(1);

        if (query.list().size() > 0)
        {
            nicknameExists = true;
        }

        closeCurrentSession();

        return nicknameExists;
    }

    public boolean emailAlreadyExists(String email)
    {
        boolean emailExists = false;

        Query query = openCurrentSession()
                .createQuery("from User where email = :email")
                .setParameter("email", email)
                .setMaxResults(1);

        if (query.list().size() > 0)
        {
            emailExists = true;
        }

        closeCurrentSession();

        return emailExists;
    }
}
