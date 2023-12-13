package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String role;
    private String address;
    private String avatar;
    private String about;

    // Constructor
    public User(String id, String fullName, String phoneNumber, String email, String role, String address) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.address = address;
        this.avatar = avatar;
        this.about = about;
    }
    
    public User(ResultSet rs) throws SQLException {
    	this.id = rs.getString("id");
        this.fullName = rs.getString("full_name");
        this.phoneNumber = rs.getString("phone_number");
        this.email = rs.getString("email");
        this.role = rs.getString("role");
        this.address = rs.getString("address");
        this.avatar = rs.getString("avatar"); 
        this.about = rs.getString("about");
    }

    // Getter and setter methods for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter methods for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter methods for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // Getter and setter for about
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
