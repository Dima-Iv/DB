package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBWorker {

    private final String SELECT_ALL = "select * from users";
    private final String DELETE_BY_ID = "delete from users where idusers = ?";
    private final String INSERT_NEW = "insert into users values (?,?,?,?,?)";
    //private static final String

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Scanner in;

    public DBWorker(Connection connection) throws SQLException {
        this.connection = connection;
        this.in = new Scanner(System.in);

        boolean cycle = true;

        while (cycle) {
            System.out.println("Menu:");
            System.out.println("Show database(enter 1);");
            System.out.println("Remove user from database by ID(enter 2);");
            System.out.println("Add user to database(enter 3);");
            System.out.println("Exit(enter 4);");

            int chooser = in.nextInt();

            switch (chooser) {
                case 1:
                    showDB();
                    break;

                case 2:
                    removeUserByID();
                    break;

                case 3:
                    addUser();
                    break;

                case 4:
                    cycle = false;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Repeat please");
                    break;
            }
        }
    }

    public void showDB() throws SQLException {
        preparedStatement = connection.prepareStatement(SELECT_ALL);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println("ID=" + resultSet.getInt(1) + ", First name=" + resultSet.getString(2) + ", Last name=" + resultSet.getString(3) + ", Age=" + resultSet.getInt(4));
        }
    }

    public void removeUserByID() throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);

        System.out.print("Enter ID: ");

        int id = in.nextInt();

        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public void addUser() throws SQLException {
        preparedStatement = connection.prepareStatement(INSERT_NEW);

        System.out.println("Enter id, first name, last name, age and password:");

        int id = in.nextInt();
        String firstName = in.next();
        String lastName = in.next();
        int age = in.nextInt();
        String pass = in.next();

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, firstName);
        preparedStatement.setString(3, lastName);
        preparedStatement.setInt(4, age);
        preparedStatement.setString(5, pass);

        preparedStatement.execute();
    }

}
