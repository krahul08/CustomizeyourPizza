package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

public class SubCategoryImageListData {

    private int image_id;
    private String image_name;
    private String sub_category_image;


    public SubCategoryImageListData(int image_id, String image_name, String sub_category_image) {
        this.image_id = image_id;
        this.image_name = image_name;
        this.sub_category_image = sub_category_image;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public String getSub_category_image() {
        return sub_category_image;
    }
}
