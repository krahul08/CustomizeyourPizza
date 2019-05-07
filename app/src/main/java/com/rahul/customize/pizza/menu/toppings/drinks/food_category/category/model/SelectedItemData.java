package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model;

public class SelectedItemData {

    private int id ;
    private String ItemName;

    public SelectedItemData(int id, String itemName) {
        this.id = id;
        ItemName = itemName;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }
}
