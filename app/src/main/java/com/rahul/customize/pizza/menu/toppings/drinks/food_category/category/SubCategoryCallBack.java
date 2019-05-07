package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;

public interface SubCategoryCallBack {

    void onSuccess(SubCategoryResponse subCategoryResponse);
    void onFailure();
}
