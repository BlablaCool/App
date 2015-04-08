package info.fges.blablacool.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Valentin on 07/04/15.
 */
@Entity
@Table(name = "payment")
public class Payment
{
    private int idPayment;
    private String paymentMethod;
    private BigDecimal amount;
    private DateTime createdAt;
    private Booking booking;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_payment", nullable = false, insertable = false, updatable = false)
    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    @Basic
    @Column(name = "payment_method", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_at", nullable = false, insertable = true, updatable = true)
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        if (idPayment != payment.idPayment) return false;
        if (paymentMethod != null ? !paymentMethod.equals(payment.paymentMethod) : payment.paymentMethod != null)
            return false;
        if (amount != null ? !amount.equals(payment.amount) : payment.amount != null) return false;
        if (createdAt != null ? !createdAt.equals(payment.createdAt) : payment.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPayment;
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
