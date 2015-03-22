package info.fges.blablacool.services;

import info.fges.blablacool.dao.RoleDao;
import info.fges.blablacool.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class RoleService extends ServiceInterface<Role,Integer>
{
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findById(Integer integer) {
        return roleDao.findById(integer);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void create(Role trip) {
        roleDao.create(trip);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void delete(Role trip) {
        roleDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        roleDao.deleteById(integer);
    }
}
