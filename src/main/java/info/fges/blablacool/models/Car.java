package info.fges.blablacool.models;

import javax.persistence.*;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
public class Car {
    private int idCar;
    private String type;
    private String registration;
    private String brand;
    private String model;
    private byte capacity;
    private User owner;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_car", nullable = false, insertable = false, updatable = false)
    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    @Basic
    @Column(name = "type", nullable = true, insertable = true, updatable = true, length = 150)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "registration", nullable = false, insertable = true, updatable = true, length = 30)
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    @Basic
    @Column(name = "brand", nullable = true, insertable = true, updatable = true, length = 100)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = true, insertable = true, updatable = true, length = 100)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "capacity", nullable = false, insertable = true, updatable = true)
    public byte getCapacity() {
        return capacity;
    }

    public void setCapacity(byte capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (capacity != car.capacity) return false;
        if (idCar != car.idCar) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (registration != null ? !registration.equals(car.registration) : car.registration != null) return false;
        if (type != null ? !type.equals(car.type) : car.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCar;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (registration != null ? registration.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (int) capacity;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id_user", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
