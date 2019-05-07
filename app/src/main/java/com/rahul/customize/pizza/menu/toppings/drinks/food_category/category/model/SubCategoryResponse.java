package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

import java.util.List;

public class SubCategoryResponse {

    private boolean success;
    private List<SubCategoryListData>sub_category_list;

    public SubCategoryResponse(boolean success, List<SubCategoryListData> sub_category_list) {
        this.success = success;
        this.sub_category_list = sub_category_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<SubCategoryListData> getSub_category_list() {
        return sub_category_list;
    }
}
