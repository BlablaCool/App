package info.fges.blablacool.services;

import info.fges.blablacool.dao.PaymentDao;
import info.fges.blablacool.helpers.MailHelper;
import info.fges.blablacool.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Service
public class PaymentService extends ServiceInterface<Payment, Integer>
{
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment findById(Integer integer)
    {
        return paymentDao.findById(integer);
    }

    @Override
    public List<Payment> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public void create(Payment payment)
    {
        paymentDao.create(payment);

        // Sending the notification...
        HashMap<String, String> mailPlaceholders = new HashMap<String, String>();
        mailPlaceholders.put("passengerNickname", payment.getBooking().getUser().getNickname());
        mailPlaceholders.put("driverNickname", payment.getBooking().getTrip().getDriver().getNickname());
        mailPlaceholders.put("tripSummary", payment.getBooking().getTrip().getDepartureStep().getPlace().getCity() + " > " + payment.getBooking().getTrip().getArrivalStep().getPlace().getCity());

        MailHelper mailHelper = new MailHelper(payment.getBooking().getTrip().getDriver().getNickname(),
                payment.getBooking().getTrip().getDriver().getEmail(),
                "payments/new",
                mailPlaceholders,
                "Voyage payé",
                "Un passager a payé son voyage");
        mailHelper.send();
    }

    @Override
    public void update(Payment payment) {
        paymentDao.update(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentDao.delete(payment);
    }

    @Override
    public void deleteById(Integer integer) {
        paymentDao.deleteById(integer);
    }
}
