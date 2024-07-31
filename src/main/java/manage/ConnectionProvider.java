package manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    static Connection con;

    public static Connection createConnection() {
        // load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection
            String user = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3307/student_manage";

            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
