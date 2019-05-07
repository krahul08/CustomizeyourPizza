package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;

public interface SubCategoryImageCallBack {

    void onSuccess(SubCategoryImageResponse subCategoryImageResponse);
    void onFailure();
}
