package model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connector {
    private static String DB_URL = "jdbc:mysql://127.0.0.1:3306/itf-department-portal";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        return conn;
    }
    
    public static void closeConnection(Connection conn, Statement stmt) throws SQLException {
    	stmt.close();
    	conn.close();
    }
}