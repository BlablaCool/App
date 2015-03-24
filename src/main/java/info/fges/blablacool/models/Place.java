package info.fges.blablacool.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
public class Place {
    private int idPlace;
    private List<info.fges.blablacool.models.TripHasPlaces> TripHasPlaces;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String publicName;
    private String privateName;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_place", nullable = false, insertable = false, updatable = false)
    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (idPlace != place.idPlace) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idPlace;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.place", cascade = CascadeType.ALL)
    public List<TripHasPlaces> getTripHasPlaces() {
        return TripHasPlaces;
    }
    public void setTripHasPlaces(List<TripHasPlaces> tripHasPlaces) {
        TripHasPlaces = tripHasPlaces;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 16777215)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "latitude", nullable = true, insertable = true, updatable = true, precision = 12)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, insertable = true, updatable = true, precision = 12)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "public_name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    @Basic
    @Column(name = "private_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }
}
