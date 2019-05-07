package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;

public interface CategoryViews {

    void showProgress(boolean show);
    void getFoodCategory(CategoryResponse categoryResponse);
    void getSubCategory(SubCategoryResponse subCategoryResponse);
    void getSubCategoryImages(SubCategoryImageResponse subCategoryImageResponse);
    void showError(String errorMessage);
}
