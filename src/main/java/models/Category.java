package models;

public class Category {
<<<<<<< HEAD

    public String id;
    public String name;
    public String description;
    public boolean active;

    public Category() {
    }

    public Category(String id, String name, String description) {
        this(id, name, description, true);
    }

    public Category(String id, String name, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
=======
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
>>>>>>> developer
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
<<<<<<< HEAD
        return this.description;
=======
        return description;
>>>>>>> developer
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
=======
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getCategoryID() {
        return categoryID;
>>>>>>> developer
    }
}
