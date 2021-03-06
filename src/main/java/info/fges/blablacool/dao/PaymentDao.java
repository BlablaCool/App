package info.fges.blablacool.dao;

import info.fges.blablacool.models.Payment;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Repository
public class PaymentDao extends DaoInterface<Payment, Integer>
{
    /**
     * Finds payment by id
     * @param integer
     * @return
     */
    @Override
    public Payment findById(Integer integer)
    {
        openCurrentSession();
        Payment payment = (Payment) currentSession.get(Payment.class, integer);
        closeCurrentSession();

        return payment;
    }

    /**
     * Finds all payments
     * @return
     */
    @Override
    public List<Payment> findAll()
    {
        openCurrentSession();
        Query query = currentSession.createQuery("from Payment");
        List<Payment> list = query.list();
        closeCurrentSession();

        return list;
    }

    /**
     * Deletes payment by id
     * @param integer
     */
    @Override
    public void deleteById(Integer integer)
    {
        openCurrentSessionWithTransaction();
        Payment paymentToDelete = (Payment) currentSession.get(Payment.class, integer);
        currentSession.delete(paymentToDelete);
        closeCurrentSessionWithTransaction();
    }
}
