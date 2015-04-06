package info.fges.blablacool.services;

import info.fges.blablacool.dao.ReviewDao;
import info.fges.blablacool.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class ReviewService extends ServiceInterface<Review,Integer>
{
    @Autowired
    private ReviewDao reviewDao;

    @Override
    public Review findById(Integer integer) {
        return reviewDao.findById(integer);
    }

    @Override
    public List<Review> findAll() {
        return reviewDao.findAll();
    }

    @Override
    public void create(Review review) {
        reviewDao.create(review);
    }

    @Override
    public void update(Review review) {
        reviewDao.update(review);
    }

    @Override
    public void delete(Review review) {
        reviewDao.delete(review);
    }

    @Override
    public void deleteById(Integer integer) {
        reviewDao.deleteById(integer);
    }
}
