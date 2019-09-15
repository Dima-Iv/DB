package dao;

import logic.Driver;
import logic.Transport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public Driver findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Driver driver = session.get(Driver.class, id);
        session.close();
        return driver;
    }

    @Override
    public void save(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Driver driver) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(driver);
        transaction.commit();
        session.close();
    }

    @Override
    public Transport findTransportById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transport transport = session.get(Transport.class, id);
        session.close();
        return transport;
    }

    @Override
    public List<Driver> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "From " + Driver.class.getSimpleName();
        List<Driver> drivers = session.createQuery(sql).list();
        session.close();
        return drivers;
    }

    @Override
    public void deleteAll() {
        List<Driver> drivers = new ArrayList<>(findAll());
        for(Driver driver : drivers){
            delete(driver);
        }
    }
}