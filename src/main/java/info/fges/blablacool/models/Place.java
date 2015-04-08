package info.fges.blablacool.models;

import org.json.simple.JSONObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
@Table(name = "place")
public class Place
{
    private int idPlace;
    private String namePublic;
    private String namePrivate;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String location;
    private String address;
    private String street;
    private String streetNumber;
    private String postalCode;
    private String city;
    private String country;
    private String countryShort;
    private List<Step> steps;
    private User user;

    public Place()
    {
    }

    public Place(JSONObject jsonPlace, User user)
    {
        this.user = user;

        this.country = (String) jsonPlace.get("country");
        this.countryShort = (String) jsonPlace.get("country_short");
        this.address = (String) jsonPlace.get("formatted_address");
        this.postalCode = (String) jsonPlace.get("postal_code");
        this.city = (String) jsonPlace.get("locality");
        this.location = (String) jsonPlace.get("location");
        this.streetNumber = (String) jsonPlace.get("street_number");
        this.street = "";

        this.latitude = new BigDecimal((String) jsonPlace.get("lat"));
        this.longitude = new BigDecimal((String) jsonPlace.get("lng"));

        this.namePublic = (String) jsonPlace.get("name");
        this.namePrivate = "Private Name";
    }

    public Place(User user)
    {
        this.namePublic = "Test Public";
        this.namePrivate = "Test Private";
        this.latitude = new BigDecimal(0);
        this.longitude = new BigDecimal(0);
        this.location = "";
        this.address = "";
        this.street = "";
        this.streetNumber = "";
        this.postalCode = "";
        this.city = "";
        this.country = "";
        this.countryShort = "";
        this.user = user;
    }

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
    @Column(name = "location", nullable = false, insertable = true, updatable = true, length = 255)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @Column(name = "street", nullable = false, insertable = true, updatable = true, length = 255)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "street_number", nullable = false, insertable = true, updatable = true, length = 42)
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "postal_code", nullable = false, insertable = true, updatable = true, length = 6)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "city", nullable = false, insertable = true, updatable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = false, insertable = true, updatable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "country_short", nullable = false, insertable = true, updatable = true, length = 45)
    public String getCountryShort() {
        return countryShort;
    }

    public void setCountryShort(String countryShort) {
        this.countryShort = countryShort;
    }

    @OneToMany(mappedBy = "place")
    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
