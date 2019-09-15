package dao;

import logic.Driver;
import logic.Transport;

import java.util.List;

public interface UserDAO {

    public Driver findById(int id);

    public void save(Driver driver);

    public void update(Driver driver);

    public void delete(Driver driver);

    public Transport findTransportById(int id);

    public List<Driver> findAll();

    public void deleteAll();
}
