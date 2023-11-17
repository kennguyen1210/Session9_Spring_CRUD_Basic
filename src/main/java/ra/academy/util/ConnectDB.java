package ra.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/student_manager";
    public static final String USER = "root";
    public static final String PASSWORD = "Phuong123456";

    public static Connection getConnection(){
        Connection conn = null;
        // khai bao driver cho class
        try {
            Class.forName(DRIVER);
            // thu hien ket noi thong tin qua DriverManager
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        try {
            if(!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
