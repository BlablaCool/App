package info.fges.blablacool.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Valentin on 06/04/15.
 */
@Entity
public class Message {
    private int idMessage;
    private Timestamp postedDate;
    private String message;
    private Trip trip;
    private User reviewer;

    @Id
    @Column(name = "id_message", nullable = false, insertable = true, updatable = true)
    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    @Basic
    @Column(name = "posted_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Timestamp postedDate) {
        this.postedDate = postedDate;
    }

    @Basic
    @Column(name = "message", nullable = false, insertable = true, updatable = true, length = 16777215)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (idMessage != message1.idMessage) return false;
        if (postedDate != null ? !postedDate.equals(message1.postedDate) : message1.postedDate != null) return false;
        if (message != null ? !message.equals(message1.message) : message1.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMessage;
        result = 31 * result + (postedDate != null ? postedDate.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
