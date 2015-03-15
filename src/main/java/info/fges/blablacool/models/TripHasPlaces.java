package info.fges.blablacool.models;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
@Table(name = "trip_has_places", catalog = "blablacool")
@AssociationOverrides({
        @AssociationOverride(name = "pk.trip", joinColumns =  @JoinColumn(name = "trip_id")),
        @AssociationOverride(name = "pk.place", joinColumns =  @JoinColumn(name = "place_id"))
})
public class TripHasPlaces implements Serializable
{
    private TripHasPlacesId pk = new TripHasPlacesId();
    private DateTime estimated_time;
    private int position;

    public TripHasPlaces() {}

    @EmbeddedId
    public TripHasPlacesId getPk() {
        return pk;
    }
    public void setPk(TripHasPlacesId tripHasPlacesId) {
        this.pk = tripHasPlacesId;
    }

    @Transient
    public Trip getTrip() {
        return pk.getTrip();
    }
    public void setTrip(Trip trip) {
        pk.setTrip(trip);
    }

    @Transient
    public Place getPlace() {
        return pk.getPlace();
    }
    public void setPlace(Place place) {
        pk.setPlace(place);
    }

    @Column(name = "estimated_time")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getEstimatedTime() {
        return this.estimated_time;
    }
    public void setEstimatedTime(DateTime et) {
        this.estimated_time = et;
    }

    @Column(name = "position", nullable = false)
    public int getPosition() {
        return this.position;
    }
    public void setPosition(int pos) {
        this.position = pos;
    }

    public boolean equals(Object o) {
        if (this == o)  return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripHasPlaces that = (TripHasPlaces) o;

        if (getPk() != null ? !getPk().equals(that.getPk()) : that.getPk() != null) return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }
}
