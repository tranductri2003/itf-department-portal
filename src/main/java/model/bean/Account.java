package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    private String username;
    private String password;

    // Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Account(ResultSet rs) throws SQLException {
    	this.username = rs.getString("username");
        this.password = rs.getString("password");
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}
