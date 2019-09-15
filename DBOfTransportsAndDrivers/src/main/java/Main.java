import services.DBWorker;

public class Main {

    public static void main(String[] args) {

        try {
            DBWorker dbWorker = new DBWorker();
        }
        catch (Exception ex){
            System.out.println(ex);
        }

    }

}
