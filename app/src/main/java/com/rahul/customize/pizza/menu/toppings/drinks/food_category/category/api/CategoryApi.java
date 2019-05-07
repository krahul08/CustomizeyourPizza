package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.api;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CategoryApi {

    @GET(Urls.SUB_URL_CATEGORY)
    Call<CategoryResponse> category_response_call();


    @GET(Urls.SUB_URL_SUB_CATEGORY)
    Call<SubCategoryResponse> sub_category_response_call(
            @Query("category_id") int categoryId);


    @GET(Urls.SUB_URL_SUB_CATEGORY_IMAGE)
    Call<SubCategoryImageResponse> sub_category_image_response_call(
            @Query("sub_category_id") int subCategoryId);

}
