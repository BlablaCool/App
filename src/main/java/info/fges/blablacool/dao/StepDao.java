package info.fges.blablacool.dao;

import info.fges.blablacool.models.Step;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 24/03/15.
 */
@Repository
public class StepDao extends DaoInterface<Step, Integer>
{
    @Override
    public Step findById(Integer integer)
    {
        openCurrentSession();
        Step step = (Step) currentSession.get(Step.class, integer);
        closeCurrentSession();

        return step;
    }

    @Override
    public List<Step> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Step");
        List<Step> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Step stepToDelete = (Step) currentSession.get(Step.class, integer);
        currentSession.delete(stepToDelete);
        closeCurrentSessionWithTransaction();
    }
}
