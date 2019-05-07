package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.provider;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.FoodCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryImageCallBack;

public interface CategoryProvider {

    void getCategoryList(FoodCategoryCallBack categoryCallBack);
    void getSubCategoryList(int categoryId, SubCategoryCallBack subCategoryCallBack);
    void getSubCategoryImage(int subCategoryId, SubCategoryImageCallBack imageCallBack);

}
