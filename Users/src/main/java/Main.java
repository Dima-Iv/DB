import service.DBService;
import service.DBWorker;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            DBService dbService = new DBService();

            DBWorker dbWorker = new DBWorker(dbService.getConnection());

            dbService.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}