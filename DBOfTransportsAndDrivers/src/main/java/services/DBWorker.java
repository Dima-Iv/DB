package services;

import logic.Driver;
import logic.Transport;

import java.util.List;
import java.util.Scanner;

public class DBWorker {

    private Scanner in;
    private UserService userService;

    public DBWorker() throws Exception {
        this.in = new Scanner(System.in);
        this.userService = new UserService();

        boolean cycle = true;

        showAllDriversAndTransports();

        while (cycle) {
            System.out.println("Menu:");
            System.out.println("Show driver and their transports by driver ID(enter 1)");
            System.out.println("Show all drivers and their transports(enter 2)");

            System.out.println("Add driver to database(enter 3);");
            System.out.println("Add transport to database(enter 4)");

            System.out.println("Remove driver from database by ID(enter 5);");
            System.out.println("Remove all drivers from database(enter 6);");

            System.out.println("Exit(enter 7);");

            int chooser = in.nextInt();

            switch (chooser) {
                case 1:
                    showDriverAndTransportsByID();
                    break;

                case 2:
                    showAllDriversAndTransports();
                    break;

                case 3:
                    addDriver();
                    break;

                case 4:
                    addTransport();
                    break;

                case 5:
                    removeDriver();
                    break;

                case 6:
                    removeAllDrivers();
                    break;

                case 7:
                    cycle = false;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Repeat please");
                    break;
            }
        }
    }

    public void showDriverAndTransportsByID() throws Exception{
        System.out.println("Enter ID");
        int id = in.nextInt();
        System.out.println(userService.findDriver(id));
    }

    public void showAllDriversAndTransports(){
        List<Driver> drivers = userService.findAllDrivers();
        for(Driver driver : drivers) {
            System.out.println(driver);
        }
    }

    public void addDriver() throws Exception{
        System.out.println("Enter name, surname and age");
        userService.saveDriver(new Driver(in.next(), in.next(), in.nextInt()));
        System.out.println("Driver added");
    }

    public void addTransport() throws Exception{
        System.out.println("Enter name, seats and driver ID");
        String name = in.next();
        int seats = in.nextInt();
        int id = in.nextInt();

        Transport transport = new Transport(name, seats);
        Driver driver = userService.findDriver(id);

        transport.setDriver(driver);
        driver.addTransport(transport);
        userService.updateDriver(driver);
        System.out.println("Transport added");
    }

    public void removeDriver() throws Exception{
        System.out.println("Enter ID");
        userService.deleteDriver(userService.findDriver(in.nextInt()));
        System.out.println("Driver deleted");
    }

    public void removeAllDrivers(){
        userService.deleteAll();
        System.out.println("Drivers deleted");
    }
}
