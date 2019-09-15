package logic;

import javax.persistence.*;

@Entity
@Table(name = "transports")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "seats")
    private int seats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver")
    private Driver driver;

    public Transport() {

    }

    public Transport(String name, int seats) {
        this.name = name;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Transport " +
                "id = " + id +
                ", name = " + name +
                ", seats = " + seats;
    }
}