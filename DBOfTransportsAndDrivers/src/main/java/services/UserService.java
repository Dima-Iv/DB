package services;

import dao.UserDAO;
import dao.UserDAOImpl;
import logic.Driver;
import logic.Transport;

import java.util.List;

public class UserService {

    private UserDAO usersDAO = new UserDAOImpl();

    public UserService() {
    }

    public Driver findDriver(int id) {
        return usersDAO.findById(id);
    }

    public void saveDriver(Driver driver) {
        usersDAO.save(driver);
    }

    public void deleteDriver(Driver driver) {
        usersDAO.delete(driver);
    }

    public void updateDriver(Driver driver) {
        usersDAO.update(driver);
    }

    public List<Driver> findAllDrivers() {
        return usersDAO.findAll();
    }

    public Transport findTransportById(int id) {
        return usersDAO.findTransportById(id);
    }

    public void deleteAll() {
        usersDAO.deleteAll();
    }

}