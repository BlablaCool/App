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
    private byte capacity;
    private User driver;
    private List<User> passengers;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_trip", nullable = false, insertable = false, updatable = false)
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

    @Basic
    @Column(name = "capacity", nullable = false, insertable = true, updatable = true)
    public byte getCapacity() {
        return capacity;
    }
    public void setCapacity(byte capacity) {
        this.capacity = capacity;
    }

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id_user", nullable = false)
    public User getDriver() {
        return driver;
    }
    public void setDriver(User driver) {
        this.driver = driver;
    }

    @ManyToMany
    @JoinTable(name = "trip_has_passengers", catalog = "blablacool", schema = "", joinColumns = @JoinColumn(name = "trip_id", referencedColumnName = "id_trip", nullable = false), inverseJoinColumns = @JoinColumn(name = "passenger_id", referencedColumnName = "id_user", nullable = false))
    public List<User> getPassengers() {
        return passengers;
    }
    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    @Transient
    public int getLeftSeats()
    {
        return (this.capacity - this.passengers.size());
    }
}
