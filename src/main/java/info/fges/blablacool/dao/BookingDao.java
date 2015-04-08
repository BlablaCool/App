package info.fges.blablacool.dao;

import info.fges.blablacool.models.Booking;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 29/03/15.
 */
@Repository
public class BookingDao extends DaoInterface<Booking, Integer>
{
    @Override
    public Booking findById(Integer integer)
    {
        openCurrentSession();
        Booking booking = (Booking) currentSession.get(Booking.class, integer);
        closeCurrentSession();

        return booking;
    }

    @Override
    public List<Booking> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Booking");
        List<Booking> list = query.list();
        closeCurrentSession();

        return list;
    }

    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Booking bookingToDelete = (Booking) currentSession.get(Booking.class, integer);
        currentSession.delete(bookingToDelete);
        closeCurrentSessionWithTransaction();
    }

    public boolean alreadyExists(Integer idTrip, Integer idUser)
    {
        openCurrentSession();
        Query query = currentSession
                .createQuery("from Booking where trip.idTrip = :idTrip AND user.id = :idUser")
                .setParameter("idTrip", idTrip)
                .setParameter("idUser", idUser);
        List<Booking> list = query.list();
        closeCurrentSession();

        return !list.isEmpty();
    }

    public List<Booking> findPendingForUser(Integer idUser)
    {
        openCurrentSession();
        Query query = currentSession
                .createQuery("from Booking where trip.driver.id = :idUser and status = :status")
                .setParameter("idUser", idUser)
                .setParameter("status", "PENDING");
        List<Booking> list = query.list();
        closeCurrentSession();

        return list;
    }

    public List<Booking> findToReviewForUser(Integer idUser)
    {
        openCurrentSession();
        Query query = currentSession
                .createQuery("SELECT booking\n" +
                        "FROM Booking booking\n" +
                        "LEFT OUTER JOIN booking.trip.steps AS step\n" +
                        "LEFT OUTER JOIN booking.review AS review\n" +
                        "WHERE review.id IS NULL AND booking.user.id = :idUser AND booking.status = 'ACCEPTED' AND step.estimatedTime < current_date \n" +
                        "GROUP BY booking")
                .setParameter("idUser", idUser);
        List<Booking> list = query.list();
        closeCurrentSession();

        return list;
    }
}
