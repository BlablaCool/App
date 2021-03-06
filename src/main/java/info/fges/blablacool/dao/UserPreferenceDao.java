package info.fges.blablacool.dao;

import info.fges.blablacool.models.UserPreference;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 27/03/15.
 */
@Repository
public class UserPreferenceDao extends DaoInterface<UserPreference, Integer>
{
    /**
     * Finds user preference by id
     * @param integer
     * @return
     */
    @Override
    public UserPreference findById(Integer integer)
    {
        openCurrentSession();
        UserPreference userPreference = (UserPreference) currentSession.get(UserPreference.class, integer);
        closeCurrentSession();

        return userPreference;
    }

    /**
     * Finds all user preferences
     * @return
     */
    @Override
    public List<UserPreference> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from UserPreference");
        List<UserPreference> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * Deletes user preference by id
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        UserPreference userPreferenceToDelete = (UserPreference) currentSession.get(UserPreference.class, integer);
        currentSession.delete(userPreferenceToDelete);
        closeCurrentSessionWithTransaction();
    }
}
