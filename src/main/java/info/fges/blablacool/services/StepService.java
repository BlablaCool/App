package info.fges.blablacool.services;

import info.fges.blablacool.dao.StepDao;
import info.fges.blablacool.models.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 24/03/15.
 */
@Service
public class StepService extends ServiceInterface<Step, Integer>
{
    @Autowired
    private StepDao stepDao;

    @Override
    public Step findById(Integer integer) {
        return stepDao.findById(integer);
    }

    @Override
    public List<Step> findAll() {
        return stepDao.findAll();
    }

    @Override
    public void create(Step step) {
        stepDao.create(step);
    }

    @Override
    public void update(Step step) {
        stepDao.update(step);
    }

    @Override
    public void delete(Step step) {
        stepDao.delete(step);
    }

    @Override
    public void deleteById(Integer integer) {
        stepDao.deleteById(integer);
    }
}
