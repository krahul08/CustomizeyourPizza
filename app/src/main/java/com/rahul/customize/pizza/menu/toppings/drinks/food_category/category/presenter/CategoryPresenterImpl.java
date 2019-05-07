package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.presenter;

import com.rahul.customize.pizza.menu.toppings.drinks.food_category.FoodCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.SubCategoryImageCallBack;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.provider.CategoryProvider;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view.CategoryViews;

public class CategoryPresenterImpl implements CategoryPresenter {

    private CategoryViews categoryViews;
    private CategoryProvider categoryProvider;

    public CategoryPresenterImpl(CategoryViews categoryViews, CategoryProvider categoryProvider) {
        this.categoryViews = categoryViews;
        this.categoryProvider = categoryProvider;
    }

    @Override
    public void getCategoryList() {
        categoryViews.showProgress(true);
        categoryProvider.getCategoryList(new FoodCategoryCallBack() {
            @Override
            public void onSuccess(CategoryResponse categoryResponse) {
                try {
                    if (categoryResponse.isSuccess()){
                        categoryViews.showProgress(false);
                        categoryViews.getFoodCategory(categoryResponse);
                    }else {
                        categoryViews.showProgress(false);
                        categoryViews.showError("Something went wrong");
                    }
                }catch (Exception e){
                    e.getMessage();
                }
            }

            @Override
            public void onFailure() {
                categoryViews.showProgress(false);
                categoryViews.showError("Please try again");
            }
        });

    }

    @Override
    public void getSubCategoryList(int categoryId) {
        categoryViews.showProgress(false);
        categoryProvider.getSubCategoryList(categoryId, new SubCategoryCallBack() {
            @Override
            public void onSuccess(SubCategoryResponse subCategoryResponse) {
                try {
                    if (subCategoryResponse.isSuccess()){
                        categoryViews.showProgress(false);
                        categoryViews.getSubCategory(subCategoryResponse);
                    }else {
                        categoryViews.showProgress(false);
                        categoryViews.showError("Something went wrong");

                    }
                }catch (Exception e){
                    e.getMessage();
                }
            }

            @Override
            public void onFailure() {
                categoryViews.showProgress(false);
                categoryViews.showError("Please try again");

            }
        });
    }

    @Override
    public void getSubCategoryImage(int subCategoryId) {
        categoryViews.showProgress(true);
        categoryProvider.getSubCategoryImage(subCategoryId, new SubCategoryImageCallBack() {
            @Override
            public void onSuccess(SubCategoryImageResponse subCategoryImageResponse) {
                try {
                    if (subCategoryImageResponse.isSuccess()){
                        categoryViews.showProgress(false);
                        categoryViews.getSubCategoryImages(subCategoryImageResponse);
                    }else {
                        categoryViews.showProgress(false);
                        categoryViews.showError("Something went wrong");
                    }

            }catch(Exception e) {
                e.getMessage();
            }
        }
            @Override
            public void onFailure() {
                categoryViews.showProgress(false);
                categoryViews.showError("Please try again");
            }
        });

    }
}
