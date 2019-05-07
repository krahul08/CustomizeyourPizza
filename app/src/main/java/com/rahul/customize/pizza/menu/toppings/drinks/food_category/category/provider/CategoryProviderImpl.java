package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.provider;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.FoodCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryImageCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.api.CategoryApi;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.helper.RetrofitServiceProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryProviderImpl implements CategoryProvider {

    private CategoryApi categoryApi;
    private RetrofitServiceProvider serviceProvider;
    private Call<CategoryResponse> categoryResponseCall;
    private Call<SubCategoryResponse> subCategoryResponseCall;
    private Call<SubCategoryImageResponse> categoryImageResponseCall;

    public CategoryProviderImpl() {
        serviceProvider= new RetrofitServiceProvider();
        categoryApi =serviceProvider.getRetrofit().create(CategoryApi.class);
    }

    @Override
    public void getCategoryList(final FoodCategoryCallBack categoryCallBack) {
        categoryResponseCall = categoryApi.category_response_call();
        categoryResponseCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                categoryCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                categoryCallBack.onFailure();
            }
        });

    }

    @Override
    public void getSubCategoryList(int categoryId, final SubCategoryCallBack subCategoryCallBack) {
        subCategoryResponseCall = categoryApi.sub_category_response_call(categoryId);
        subCategoryResponseCall.enqueue(new Callback<SubCategoryResponse>() {
            @Override
            public void onResponse(Call<SubCategoryResponse> call, Response<SubCategoryResponse> response) {
                subCategoryCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCategoryResponse> call, Throwable t) {
                subCategoryCallBack.onFailure();
                t.getMessage();

            }
        });

    }

    @Override
    public void getSubCategoryImage(int subCategoryId, final SubCategoryImageCallBack imageCallBack) {
        categoryImageResponseCall = categoryApi.sub_category_image_response_call(subCategoryId);
        categoryImageResponseCall.enqueue(new Callback<SubCategoryImageResponse>() {
            @Override
            public void onResponse(Call<SubCategoryImageResponse> call, Response<SubCategoryImageResponse> response) {
                imageCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<SubCategoryImageResponse> call, Throwable t) {
                imageCallBack.onFailure();
                t.printStackTrace();
            }
        });

    }
}
