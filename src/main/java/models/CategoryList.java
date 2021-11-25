package models;

import java.util.ArrayList;

public class CategoryList {

    private ArrayList<Category> categories;

    public CategoryList() {

    }

    public ArrayList<Category> getCategoryList() {
        return this.categories;
    }

    public void setCategoryList(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
