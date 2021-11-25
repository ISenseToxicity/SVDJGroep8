package controllers;

import models.Category;

public class CategoryController implements Controller {

    public CategoryController() {
    }

    public void setFalse(Category category) {
        category.setActive(false);
    }

}