package info.fges.blablacool.dao;

import info.fges.blablacool.models.Review;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class ReviewDao extends DaoInterface<Review, Integer>
{
    /**
     * Finds review by id
     * @param integer
     * @return
     */
    @Override
    public Review findById(Integer integer)
    {
        openCurrentSession();
        Review review = (Review) currentSession.get(Review.class, integer);
        closeCurrentSession();

        return review;
    }

    /**
     * Finds all reviews
     * @return
     */
    @Override
    public List<Review> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Review");
        List<Review> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * Deletes review by id
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Review reviewToDelete = (Review) currentSession.get(Review.class, integer);
        currentSession.delete(reviewToDelete);
        closeCurrentSessionWithTransaction();
    }
}
