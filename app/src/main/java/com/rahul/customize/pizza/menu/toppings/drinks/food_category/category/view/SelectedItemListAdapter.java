package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rahul.customize.pizza.menu.toppings.drinks.R;

import java.util.ArrayList;

public class SelectedItemListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList <String> itemsArrayList = new ArrayList<String>();
    private Context context;


    public SelectedItemListAdapter(Context context) {
        this.context = context;
        if (context != null) {
            layoutInflater = LayoutInflater.from(this.context);
        }
    }
    @NonNull
    @Override
    public selected_list_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_selected_layout, parent, false);

        return new SelectedItemListAdapter.selected_list_holder(view);
    }

    public void setData(ArrayList<String> data) {
        this.itemsArrayList = data;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final SelectedItemListAdapter.selected_list_holder selected_list_holder = (SelectedItemListAdapter.selected_list_holder) holder;
        selected_list_holder.itemName.setText(itemsArrayList.get(position));

    }
    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }

    class selected_list_holder extends RecyclerView.ViewHolder {

        private TextView itemName,itemQuantity,itemPrice;

        selected_list_holder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemPrice = itemView.findViewById(R.id.itemPrice);


        }
    }
}
