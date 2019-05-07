package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

import java.util.List;

public class SubCategoryImageResponse {

    private boolean success;
    private String category_image;
    private String sub_category_name;
    private String sub_category_price;
    private String sub_category_description;
    private List<SubCategoryImageListData>sub_category_image_list;


    public SubCategoryImageResponse(boolean success, String category_image, String sub_category_name, String sub_category_price, String sub_category_description, List<SubCategoryImageListData> sub_category_image_list) {
        this.success = success;
        this.category_image = category_image;
        this.sub_category_name = sub_category_name;
        this.sub_category_price = sub_category_price;
        this.sub_category_description = sub_category_description;
        this.sub_category_image_list = sub_category_image_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCategory_image() {
        return category_image;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public String getSub_category_price() {
        return sub_category_price;
    }

    public String getSub_category_description() {
        return sub_category_description;
    }

    public List<SubCategoryImageListData> getSub_category_image_list() {
        return sub_category_image_list;
    }
}
