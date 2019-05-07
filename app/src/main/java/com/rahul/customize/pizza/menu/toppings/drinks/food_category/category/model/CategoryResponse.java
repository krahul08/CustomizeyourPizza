package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

import java.util.List;

public class CategoryResponse {

    private boolean success;
    private List<CategoryListData> category_list;

    public CategoryResponse(boolean success, List<CategoryListData> category_list) {
        this.success = success;
        this.category_list = category_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<CategoryListData> getCategory_list() {
        return category_list;
    }

}
