package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
    private int id;
    private String title;

    // Constructor
    public Category(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Category(ResultSet rs) throws SQLException {
    	this.id = rs.getInt("id");
        this.title = rs.getString("title");
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }
}
