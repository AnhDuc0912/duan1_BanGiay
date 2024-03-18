package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static Connection con = null;
    public static ConnectDB instance = new ConnectDB();

    public static Connection getCon() {
        return con;
    }

    public static ConnectDB getInstance() {
        return instance;
    }

    public void connect() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String uri = "jdbc:sqlserver://localhost:1435;DatabaseName=Sneacker_Store";
            String user = "sa";
            String pw = "Abc@123456789";

            con = DriverManager.getConnection(uri, user, pw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void diconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
