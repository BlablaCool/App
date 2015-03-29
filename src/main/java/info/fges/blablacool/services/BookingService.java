package info.fges.blablacool.services;

import info.fges.blablacool.dao.BookingDao;
import info.fges.blablacool.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Valentin on 29/03/15.
 */
@Service
public class BookingService extends ServiceInterface<Booking, Integer>
{
    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking findById(Integer integer) {
        return bookingDao.findById(integer);
    }

    @Override
    public List<Booking> findAll() {
        return bookingDao.findAll();
    }

    @Override
    public void create(Booking trip) {
        bookingDao.create(trip);
    }

    @Override
    public void update(Booking car)
    {
        bookingDao.update(car);
    }

    @Override
    public void delete(Booking trip) {
        bookingDao.delete(trip);
    }

    @Override
    public void deleteById(Integer integer) {
        bookingDao.deleteById(integer);
    }

    public boolean alreadyExists(Integer idTrip, Integer idUser)
    {
        return bookingDao.alreadyExists(idTrip, idUser);
    }

    public List<Booking> findPendingForUser(Integer idUser)
    {
        return bookingDao.findPendingForUser(idUser);
    }
}
