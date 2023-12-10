package model.bean;

public class Category {
    private String id;
    private String title;

    // Constructor
    public Category(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
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
