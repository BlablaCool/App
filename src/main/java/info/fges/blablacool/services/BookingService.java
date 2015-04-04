package info.fges.blablacool.services;

import info.fges.blablacool.dao.BookingDao;
import info.fges.blablacool.helpers.MailHelper;
import info.fges.blablacool.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void create(Booking booking) {
        bookingDao.create(booking);
    }

    @Override
    public void update(Booking booking)
    {
        bookingDao.update(booking);
    }

    @Override
    public void delete(Booking booking) {
        bookingDao.delete(booking);
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

    public void acceptBooking(Booking booking)
    {
        booking.setStatus("ACCEPTED");
        bookingDao.update(booking);

        // Sending the notification...
        HashMap<String, String> mailPlaceholders = new HashMap<String, String>();
        mailPlaceholders.put("passengerNickname", booking.getUser().getNickname());
        mailPlaceholders.put("driverNickname", booking.getTrip().getDriver().getNickname());
        mailPlaceholders.put("bookingUrl", "http://localhost:8080/booking/" + booking.getId());

        MailHelper mailHelper = new MailHelper(booking.getUser().getNickname(),
                booking.getUser().getEmail(),
                "booking/accepted",
                mailPlaceholders,
                "Réservation confirmée !",
                "Votre réservation sur BlablaCool est confirmée");
        mailHelper.send();
    }

    public void declineBooking(Booking booking)
    {
        booking.setStatus("DECLINED");
        bookingDao.update(booking);

        // Sending the notification...
        //TODO
    }

    public void cancelBooking(Booking booking)
    {
        booking.setStatus("CANCELLED");
        bookingDao.update(booking);

        // Sending the notification...
        HashMap<String, String> mailPlaceholders = new HashMap<String, String>();
        mailPlaceholders.put("passengerNickname", booking.getUser().getNickname());
        mailPlaceholders.put("driverNickname", booking.getTrip().getDriver().getNickname());
        mailPlaceholders.put("tripSummary", booking.getTrip().getDepartureStep().getPlace().getCity() + " > " + booking.getTrip().getArrivalStep().getPlace().getCity());
        mailPlaceholders.put("bookingUrl", "http://localhost:8080/booking/" + booking.getId());

        MailHelper mailHelper = new MailHelper(booking.getTrip().getDriver().getNickname(),
                booking.getTrip().getDriver().getEmail(),
                "booking/cancelled",
                mailPlaceholders,
                "Réservation annulée",
                "Un passager a annulé sa réservation");
        mailHelper.send();
    }
}
