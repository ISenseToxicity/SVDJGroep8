package models;

public class Category {

    public Long categoryID;
    public String name;
    public String description;
    public boolean active;

    public Category() {
    }

    public Category(Long categoryID, String name, String description) {
        this(categoryID, name, description, true);
    }

    public Category(Long categoryID, String name, String description, boolean active) {
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.active = active;

    }

    public Long getCategoryID() {
        return this.categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
