package info.fges.blablacool.services;

import info.fges.blablacool.dao.UserPreferenceDao;
import info.fges.blablacool.models.UserPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 27/03/15.
 */
@Service
public class UserPreferenceService extends ServiceInterface<UserPreference, Integer>
{
    @Autowired
    private UserPreferenceDao userPreferenceDao;

    @Override
    public UserPreference findById(Integer integer) {
        return userPreferenceDao.findById(integer);
    }

    @Override
    public List<UserPreference> findAll() {
        return userPreferenceDao.findAll();
    }

    @Override
    public void create(UserPreference preference) {
        userPreferenceDao.create(preference);
    }

    @Override
    public void update(UserPreference preference) {
        userPreferenceDao.update(preference);
    }

    @Override
    public void delete(UserPreference preference) {
        userPreferenceDao.delete(preference);
    }

    @Override
    public void deleteById(Integer integer) {
        userPreferenceDao.deleteById(integer);
    }
}
