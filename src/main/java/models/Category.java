package models;

public class Category {
    private Long categoryID;

    private String name;
    private String description;

    public Category(Long categoryID, String name, String description) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
    }

    public Category() {
    }

    //    Setters and Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    @Override
    public String toString() {
        return "{" +
                "\"categoryID\": " + categoryID + ',' +
                "\"description\": \"" + description + "\"," +
                "\"name\": \"" + name + '\"' +
                '}';
    }
}
