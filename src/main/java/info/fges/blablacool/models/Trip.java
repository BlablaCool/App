package info.fges.blablacool.models;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
@Table(name = "trip")
public class Trip
{
    private int idTrip;
    private Short capacity;
    private User driver;
    private boolean allowSmoking;
    private boolean allowAnimals;
    private String luggage;
    private BigDecimal price;
    private List<Step> steps;
    private List<Booking> booking;
    private List<Message> messages;

    public Trip()
    {
    }

    public Trip(Trip trip)
    {
        this.driver = trip.getDriver();
        this.capacity = trip.getCapacity();
        this.allowSmoking = trip.isAllowSmoking();
        this.allowAnimals = trip.isAllowAnimals();
        this.luggage = trip.getLuggage();
        this.price = trip.getPrice();
    }

    public Trip(JSONObject jsonTrip, User user)
    {
        this.driver = user;
        this.capacity = Short.valueOf((String) jsonTrip.getOrDefault("availableSeats", "4"));
        this.allowSmoking = Boolean.parseBoolean((String) jsonTrip.getOrDefault("allowSmokers", "False"));
        this.allowAnimals = Boolean.parseBoolean((String) jsonTrip.getOrDefault("allowAnimals", "False"));
        this.luggage = (String) jsonTrip.getOrDefault("bags", "HEAVY");
        this.price = new BigDecimal((String) jsonTrip.getOrDefault("price", 0));
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

    @ManyToOne
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

    @OneToMany(mappedBy = "trip")
    @OrderBy("createdAt DESC")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Transient
    public Boolean hasAcceptedBookings()
    {
        for (Booking booking : this.booking)
        {
            if (booking.isAccepted())
            {
                return true;
            }
        }

        return false;
    }

    @Transient
    public List<Booking> getAcceptedBookings()
    {
        List<Booking> bookings = new ArrayList<Booking>();

        for (Booking booking : this.booking)
        {
            if (booking.isAccepted())
            {
                bookings.add(booking);
            }
        }

        return bookings;
    }
}
