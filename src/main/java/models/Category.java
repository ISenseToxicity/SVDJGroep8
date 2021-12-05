package models;

public class Category {

    public Long id;
    public String name;
    public String description;
    public boolean active;

    public Category() {
    }

    public Category(Long id, String name, String description) {
        this(id, name, description, true);
    }

    public Category(Long id, String name, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "\"categoryID\": " + id + ',' +
                "\"description\": \"" + description + "\"," +
                "\"name\": \"" + name + '\"' +
                '}';
    }
}
