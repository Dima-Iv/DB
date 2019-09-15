package logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "age")
    private int age;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Transport> transports;

    public Driver() {
    }

    public Driver(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        transports = new ArrayList<>();
    }

    public void addTransport(Transport transport) {
        transport.setDriver(this);
        transports.add(transport);
    }

    public void removeTransport(Transport transport) {
        transports.remove(transport);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }

    @Override
    public String toString() {
        return "Driver " +
                "id = " + id +
                ", name = " + name +
                ", surname = " + surname +
                ", age = " + age +
                ", transports = " + transports;
    }
}
