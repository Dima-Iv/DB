package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "root";


    private Connection connection;

    public DBService() {

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            if (!connection.isClosed()) {
                System.out.println("The connection is established");
            }
        }catch(SQLException e){
                System.out.println("No DB connection");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
