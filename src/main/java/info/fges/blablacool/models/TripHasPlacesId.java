package info.fges.blablacool.models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Valentin on 15/03/15.
 */
@Embeddable
public class TripHasPlacesId implements Serializable
{
    private Trip trip;
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Place getPlace() {
        return place;
    }
    public void setPlace(Place place) {
        this.place = place;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripHasPlacesId that = (TripHasPlacesId) o;

        if (trip != null ? !trip.equals(that.trip) : that.trip != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;

        return true;
    }

    public int hashCode()
    {
        int result;
        result = (trip != null ? trip.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);

        return result;
    }
}
