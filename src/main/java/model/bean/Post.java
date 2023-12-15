package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Post {
    private int id;
    private int category;
    private String title;
    private String image;
    private String excerpt;
    private String content;
    private String author;
    private Date date;
    private int numViews;
    public static final String DEFAULT_POST = "media/post/default.jpg";

    // Constructor
    public Post(int id, int category, String title, String image, String excerpt, String content, String author, Date date, int numViews) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.image = image;
        this.excerpt = excerpt;
        this.content = content;
        this.author = author;
        this.date = date;
        this.numViews = numViews;
    }
    
    public Post(ResultSet rs) throws SQLException {
    	this.id = rs.getInt("id");
    	this.category = rs.getInt("category");
        this.title = rs.getString("title");
        this.image = rs.getString("image");
        this.excerpt = rs.getString("excerpt");
        this.content = rs.getString("content");
        this.author = rs.getString("author");
        this.date = rs.getDate("date");
        this.numViews = rs.getInt("num_views");
    }

    // Getter and setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for category
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    // Getter and setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for image
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Getter and setter methods for excerpt
    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    // Getter and setter methods for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and setter methods for author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter and setter methods for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and setter methods for numViews
    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }
}
