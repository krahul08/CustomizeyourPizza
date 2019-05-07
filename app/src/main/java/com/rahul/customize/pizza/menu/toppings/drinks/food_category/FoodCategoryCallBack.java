package com.rahul.customize.pizza.menu.toppings.drinks.food_category;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;

public interface FoodCategoryCallBack {

    void onSuccess(CategoryResponse categoryResponse);
    void onFailure();
}
