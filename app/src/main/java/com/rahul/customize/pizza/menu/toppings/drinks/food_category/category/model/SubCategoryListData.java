package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

public class SubCategoryListData {

    private int sub_category_id;
    private String sub_category_name;
    private String sub_category_image;
    private String sub_category_price;

    public SubCategoryListData(int sub_category_id, String sub_category_name, String sub_category_image, String sub_category_price) {
        this.sub_category_id = sub_category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_image = sub_category_image;
        this.sub_category_price = sub_category_price;
    }

    public int getSub_category_id() {
        return sub_category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public String getSub_category_image() {
        return sub_category_image;
    }

    public String getSub_category_price() {
        return sub_category_price;
    }
}
