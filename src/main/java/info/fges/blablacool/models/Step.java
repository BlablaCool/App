package info.fges.blablacool.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Valentin on 24/03/15.
 */
@Entity
public class Step {
    private Integer position;
    private Timestamp estimatedTime;
    private Place place;
    private Trip trip;
    private int idStep;

    public Step()
    {

    }

    public Step(Trip trip, Place place)
    {
        this.trip = trip;
        this.place = place;
    }

    public Step(Trip trip, Place place, Integer position)
    {
        this.trip = trip;
        this.place = place;
        this.position = position;
    }

    public Step(Trip trip, Place place, Integer position, Timestamp estimatedTime)
    {
        this.trip = trip;
        this.place = place;
        this.position = position;
        this.estimatedTime = estimatedTime;
    }

    @Basic
    @Column(name = "position", nullable = true, insertable = true, updatable = true)
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Basic
    @Column(name = "estimated_time", nullable = true, insertable = true, updatable = true)
    public Timestamp getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Timestamp estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Step step = (Step) o;

        if (estimatedTime != null ? !estimatedTime.equals(step.estimatedTime) : step.estimatedTime != null)
            return false;
        if (position != null ? !position.equals(step.position) : step.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (estimatedTime != null ? estimatedTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id_place", nullable = false)
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @ManyToOne
    @JoinColumn(name = "trip_id", referencedColumnName = "id_trip", nullable = false)
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_step", nullable = false, insertable = false, updatable = false)
    public int getIdStep() {
        return idStep;
    }

    public void setIdStep(int idStep) {
        this.idStep = idStep;
    }
}
