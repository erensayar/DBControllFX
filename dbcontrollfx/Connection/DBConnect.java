package dbcontrollfx.Connection;

import dbcontrollfx.Controller.AdminGirisController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static Connection conn;
    private static String port = AdminGirisController.port;
    private static String host = AdminGirisController.host;
    private static String name = AdminGirisController.name;
    private static String password = AdminGirisController.password;
    private static String url = "jdbc:mysql://" + host + ":" + port + "/" + AdminGirisController.dbName;

    public static Connection connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
        try {
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return conn;
    }

    public static boolean tryConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            return false;
        }
        try {
            conn = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            return false;
        }
        return true;
        
    }



}
