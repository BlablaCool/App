package info.fges.blablacool.models;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
public class Trip {
    private int idTrip;
    private Short capacity;
    private User driver;
    private List<Step> steps;
    private boolean allowSmoking;
    private boolean allowAnimals;
    private String luggage;
    private BigDecimal price;
    private List<Booking> booking;

    public Trip()
    {
        System.out.println("here we are");
    }

    public Trip(JSONObject jsonTrip, User user)
    {
        this.driver = user;
        this.capacity = Short.valueOf((String) jsonTrip.get("availableSeats"));
        this.allowSmoking = Boolean.parseBoolean((String) jsonTrip.getOrDefault("allowSmokers", "False"));
        this.allowAnimals = Boolean.parseBoolean((String) jsonTrip.getOrDefault("allowAnimals", "False"));
        this.luggage = (String) jsonTrip.get("bags");
        this.price = new BigDecimal((String) jsonTrip.getOrDefault("price", 0));

        System.out.println(this);
    }

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

    @Basic
    @Column(name = "capacity", columnDefinition = "TINYINT", nullable = false, insertable = true, updatable = true)
    public Short getCapacity() {
        return capacity;
    }

    public void setCapacity(Short capacity) {
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

    @Transient
    public int getLeftSeats()
    {
        return (this.capacity - this.booking.size());
    }

    @OneToMany(mappedBy = "trip")
    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Basic
    @Column(name = "smoking", nullable = false, insertable = true, updatable = true)
    public boolean isAllowSmoking() {
        return allowSmoking;
    }

    public void setAllowSmoking(boolean allowSmoking) {
        this.allowSmoking = allowSmoking;
    }

    @Basic
    @Column(name = "animals", nullable = false, insertable = true, updatable = true)
    public boolean isAllowAnimals() {
        return allowAnimals;
    }

    public void setAllowAnimals(boolean allowAnimals) {
        this.allowAnimals = allowAnimals;
    }

    @Basic
    @Column(name = "luggage", nullable = true, insertable = true, updatable = true, length = 50)
    public String getLuggage() {
        return luggage;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Transient
    public Step getDepartureStep()
    {
        if (this.steps.size() > 0)
        {
            return steps.get(0);
        }

        return null;
    }

    @Transient
    public Step getArrivalStep()
    {
        if (this.steps.size() > 0)
        {
            return steps.get(this.steps.size() - 1);
        }

        return null;
    }

    @Transient
    public JSONArray getStepsInJson()
    {
        JSONArray jsonArray = new JSONArray();

        for (Step step : this.steps)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("lat", step.getPlace().getLatitude());
            jsonObject.put("lon", step.getPlace().getLongitude());

            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    @OneToMany(mappedBy = "trip")
    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
