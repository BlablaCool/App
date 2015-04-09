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
    /**
     * Finds user by email
     * @param email
     * @return
     */
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

    /**
     * Finds user by id
     * @param integer
     * @return
     */
    @Override
    public User findById(Integer integer)
    {
        openCurrentSession();
        User user = (User) currentSession.get(User.class, integer);
        closeCurrentSession();

        return user;
    }

    /**
     * Finds all users
     * @return
     */
    @Override
    public List<User> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from User");
        List<User> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * 
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        User userToDelete = (User) currentSession.get(User.class, integer);
        currentSession.delete(userToDelete);
        closeCurrentSessionWithTransaction();
    }

    /**
     * searches nickname and return true if exists
     * @param nickname
     * @return
     */
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

    /**
     * searches email and return true if exists
     * @param email
     * @return
     */
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
