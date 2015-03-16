package info.fges.blablacool.dao;

import info.fges.blablacool.models.Role;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class RoleDao extends DaoInterface<Role, Integer>
{
    @Override
    public Role findById(Integer integer)
    {
        openCurrentSession();
        Role role = (Role) currentSession.get(Role.class, integer);
        closeCurrentSession();

        return role;
    }

    @Override
    public List<Role> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Role");
        List<Role> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Role roleToDelete = (Role) currentSession.get(Role.class, integer);
        currentSession.delete(roleToDelete);
        closeCurrentSessionWithTransaction();
    }
}
