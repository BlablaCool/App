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
    private String namePublic;
    private String namePrivate;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String address;
    private String gmapsPlaceId;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_place", nullable = false, insertable = true, updatable = true)
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
    @Column(name = "name_public", nullable = false, insertable = true, updatable = true, length = 255)
    public String getNamePublic() {
        return namePublic;
    }

    public void setNamePublic(String namePublic) {
        this.namePublic = namePublic;
    }

    @Basic
    @Column(name = "name_private", nullable = false, insertable = true, updatable = true, length = 255)
    public String getNamePrivate() {
        return namePrivate;
    }

    public void setNamePrivate(String namePrivate) {
        this.namePrivate = namePrivate;
    }

    @Basic
    @Column(name = "latitude", nullable = false, insertable = true, updatable = true, precision = 18)
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = false, insertable = true, updatable = true, precision = 18)
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "gmaps_place_id", nullable = false, insertable = true, updatable = true, length = 42)
    public String getGmapsPlaceId() {
        return gmapsPlaceId;
    }

    public void setGmapsPlaceId(String gmapsPlaceId) {
        this.gmapsPlaceId = gmapsPlaceId;
    }
}
