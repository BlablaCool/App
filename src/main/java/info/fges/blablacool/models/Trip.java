package info.fges.blablacool.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
public class Trip {
    private int idTrip;
    private List<TripHasPlaces> TripHasPlaces;

    @Id
    @Column(name = "id_trip", nullable = false, insertable = true, updatable = true)
    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (idTrip != trip.idTrip) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idTrip;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.trip", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<TripHasPlaces> getTripHasPlaces() {
        return TripHasPlaces;
    }
    public void setTripHasPlaces(List<TripHasPlaces> tripHasPlaces) {
        TripHasPlaces = tripHasPlaces;
    }
}
