package models;

import java.util.ArrayList;

public class CategoryList {

    private ArrayList<Category> categories;
    private ArrayList<Category> activeCategories;

    public CategoryList() {
    }

    public ArrayList<Category> getCategoryList() {
        return this.categories;
    }

    public ArrayList<Category> getActiveCategories() {
        return this.activeCategories;
    }

    public void setCategoryList(ArrayList<Category> categories) {
        this.categories = categories;
        setActiveCategories(categories);
    }

    public void setActiveCategories(ArrayList<Category> categories) {
        this.activeCategories = categories;
    }

    public void removeActiveCategory(String id) {
        activeCategories.removeIf(activeCategory -> id.equals(activeCategory.getId()));
    }

}
