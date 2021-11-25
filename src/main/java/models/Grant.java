package models;

import java.util.ArrayList;
import java.util.Date;

public class Grant {

    private String id;
    private String name;
    private Date period;
    private String type;
    private String info;
    private ArrayList<Category> categories;

    public Grant() {

    }

    public Grant(String id, String name, Date period, String type, String info, ArrayList<Category> categories) {
        this.id = id;
        this.name = name;
        this.period = period;
        this.type = type;
        this.info = info;
        this.categories = categories;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPeriod() {
        return this.period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategoryToGrant(Category category) {
        this.categories.add(category);
    }

    public void removeCategoryFromGrant(Category category) {
        this.categories.remove(category);
    }
}
