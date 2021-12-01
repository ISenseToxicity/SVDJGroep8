package controllers;

import models.Category;
import models.CategoryList;

import java.util.ArrayList;

public class CategoryListController implements Controller {

    private final CategoryList categoryList;

    public CategoryListController() {
        categoryList = new CategoryList();
        //TODO get categories from BO and set them
    }

    public ArrayList<Category> getCategoryList() {
        return this.categoryList.getCategoryList();
    }

    public void setCategoryList(ArrayList<Category> categories) {
        categoryList.setCategoryList(categories);
    }

    public ArrayList<Category> getActiveCategories() {
        return categoryList.getActiveCategories();
    }

    public void removeActiveCategory(String id) {
        this.categoryList.removeActiveCategory(id);
    }
}
