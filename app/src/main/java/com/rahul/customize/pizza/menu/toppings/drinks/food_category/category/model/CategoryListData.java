package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

public class CategoryListData {

    private int category_id;
    private String category_name;
    private String category_image;


    public CategoryListData(int category_id, String category_name, String category_image) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_image = category_image;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getCategory_image() {
        return category_image;
    }
}
