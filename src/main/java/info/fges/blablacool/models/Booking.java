package info.fges.blablacool.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by Valentin on 29/03/15.
 */
@Entity
@Table(name = "booking")
public class Booking
{
    private int id;
    private String status;
    private Step step;
    private Trip trip;
    private User user;
    private DateTime createdTime;

    public Booking()
    {
        this.createdTime = DateTime.now();
    }

    public Booking(Trip _trip, User _user, String _status)
    {
        this.trip = _trip;
        this.user = _user;
        this.step = _trip.getDepartureStep();
        this.status = _status;
        this.createdTime = DateTime.now();
    }

    public Booking(Trip _trip, User _user, Step _step, String _status)
    {
        this.trip = _trip;
        this.user = _user;
        this.step = _step;
        this.status = _status;
        this.createdTime = DateTime.now();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status", nullable = false, insertable = true, updatable = true, length = 8)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (id != booking.id) return false;
        if (status != null ? !status.equals(booking.status) : booking.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "step_id", referencedColumnName = "id_step", nullable = false)
    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id_trip", nullable = false)
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_time", nullable = true, insertable = true, updatable = true)
    public DateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Transient
    public Boolean isAccepted()
    {
        return this.status.contentEquals("ACCEPTED");
    }

    @Transient
    public Boolean isDeclined()
    {
        return this.status.contentEquals("DECLINED");
    }

    @Transient
    public Boolean isPending()
    {
        return this.status.contentEquals("PENDING");
    }

    @Transient
    public Boolean isCancelled()
    {
        return this.status.contentEquals("CANCELLED");
    }
}
