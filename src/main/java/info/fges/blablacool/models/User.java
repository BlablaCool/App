package info.fges.blablacool.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
@Table(name = "user")
public class User implements UserDetails
{
    private int id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    @NotEmpty @Email
    private String email;

    @NotEmpty @Length(min = 2, max = 20)
    private String nickname;

    @NotEmpty
    private String password;

    @Transient
    @NotEmpty
    private String passwordConfirmation;

    private List<Car> cars;
    private List<Role> roles;

    private Byte age;
    private List<Subscription> subscriptions;
    private List<Place> places;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private UserPreference preferences;
    private List<Booking> booking;
    private List<Trip> trips;
    private List<Message> messages;
    private List<Review> reviewsReceived;
    private Review reviewsGiven;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "owner")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_roles", catalog = "blablacool", schema = "", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id_role", nullable = false))
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "nickname", nullable = false, insertable = true, updatable = true, length = 42)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 200)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @Transient
    public List<GrantedAuthority> getAuthorities()
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        /**
         * Getting roles from DB
         */
        for (Role userRole : this.roles)
        {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        /**
         * Checking if user has valid subscription
         */
        if (this.hasActiveSubscription())
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_SUBSCRIBED"));
        }

        return authorities;
    }

    @Override
    @Transient
    public String getUsername() {
        return this.email;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }

    @Transient
    public boolean hasActiveSubscription()
    {
        for (Subscription subscription : this.subscriptions)
        {
            if ( (DateTime.now().isAfter(subscription.getFrom())) &&
                    (DateTime.now().isBefore(subscription.getTo())) )
            {
                return true;
            }
        }

        return false;
    }

    @Basic
    @Column(name = "age", nullable = true, insertable = true, updatable = true)
    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Transient
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    @OneToMany(mappedBy = "user")
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @OneToMany(mappedBy = "user")
    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "address", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, insertable = true, updatable = true, length = 180)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, insertable = true, updatable = true, length = 255)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "postcode", nullable = true, insertable = true, updatable = true, length = 10)
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "country", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToOne(mappedBy = "user")
    public UserPreference getPreferences() {
        return preferences;
    }

    public void setPreferences(UserPreference preferences) {
        this.preferences = preferences;
    }

    @OneToMany(mappedBy = "user")
    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @OneToMany(mappedBy = "driver")
    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Transient
    public List<Trip> getDriverUpcomingTrips()
    {
        List<Trip> tripList = new ArrayList<Trip>(this.trips);

        for (Iterator<Trip> iterator = tripList.iterator(); iterator.hasNext();)
        {
            Trip trip = iterator.next();

            if (trip.getDepartureStep().getEstimatedTime().isBeforeNow())
            {
                iterator.remove();
            }
        }

        return tripList;
    }

    @Transient
    public List<Trip> getDriverLastTrips()
    {
        List<Trip> tripList = new ArrayList<Trip>(this.trips);

        for (Iterator<Trip> iterator = tripList.iterator(); iterator.hasNext();)
        {
            Trip trip = iterator.next();

            if (trip.getArrivalStep().getEstimatedTime().isAfterNow())
            {
                iterator.remove();
            }
        }

        return tripList;
    }

    @OneToMany(mappedBy = "sender")
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @OneToOne(mappedBy = "reviewer")
    public Review getReviewsGiven() {
        return reviewsGiven;
    }

    public void setReviewsGiven(Review reviewsGiven) {
        this.reviewsGiven = reviewsGiven;
    }
}
