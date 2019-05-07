package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rahul.customize.pizza.menu.toppings.drinks.R;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryListData;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryListData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class SubCategoryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private LayoutInflater layoutInflater;
    private List<SubCategoryListData> subCatListData;
    private Context context;
    private int row_index = -1;
    private CategoryActivity categoryActivity;



    public SubCategoryListAdapter(Context context, CategoryActivity categoryActivity) {
        this.context = context;
        if (context != null) {
            layoutInflater = LayoutInflater.from(context);
            this.categoryActivity=categoryActivity;
        }
    }

    @NonNull
    @Override
    public  list_holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.sub_ategory_list_layout, viewGroup, false);

        return new list_holder(view) {
        };
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        final SubCategoryListAdapter.list_holder listHolder =(SubCategoryListAdapter.list_holder)viewHolder;
        final SubCategoryListData subCategoryListData = subCatListData.get(position);

        listHolder.categoryName.setText(subCategoryListData.getSub_category_name());
        Glide.with(context).load(subCategoryListData.getSub_category_image()).into(listHolder.foodCategoryImage);
        listHolder.categoryItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                categoryActivity.showSubCategoryImages(subCategoryListData.getSub_category_id());
                notifyDataSetChanged();
            }
        });
        if (row_index==position){

            ((list_holder) viewHolder).imageLayout.setBackgroundColor(Color.parseColor("#4C64AE"));
            listHolder.arrow.setVisibility(View.VISIBLE);
            ((list_holder) viewHolder).imageLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.circular_shape_navy_blue));

        }else {
            ((list_holder) viewHolder).imageLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            listHolder.arrow.setVisibility(View.GONE);
            ((list_holder) viewHolder).imageLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.circular_shape_design_for_layout));
        }
    }

    @Override
    public int getItemCount() {
        return subCatListData.size();
    }

    public void setData(List<SubCategoryListData> dataList) {
        this.subCatListData = dataList;
    }

    class list_holder extends RecyclerView.ViewHolder {
        private CircleImageView foodCategoryImage;
        private ProgressBar ProgressBar;
        private TextView categoryName;
        private LinearLayout categoryItemLayout;
        private LinearLayout imageLayout;
        private ImageView arrow;



//        some issue is showing while using butterknife
//        may be version issue


//        @BindView(R.id.foodCategoryImage)
//        CircleImageView foodCategoryImage;
//        @BindView(R.id.imageProgress)
//        ProgressBar imageProgress;
//        @BindView(R.id.image_card)
//        LinearLayout imageCard;
//        @BindView(R.id.categoryName)
//        TextView categoryName;
//        @BindView(R.id.categoryNameLayout)
//        LinearLayout categoryNameLayout;
//        @BindView(R.id.categoryItemLayout)
//        RelativeLayout categoryItemLayout;


        public list_holder(@NonNull View itemView) {
            super(itemView);
            foodCategoryImage= itemView.findViewById(R.id.foodCategoryImage);
//            ProgressBar= itemView.findViewById(R.id.imageProgress);
            categoryName= itemView.findViewById(R.id.categoryName);
            categoryItemLayout= itemView.findViewById(R.id.categoryItemLayout);
            imageLayout= itemView.findViewById(R.id.imageLayout);
            arrow= itemView.findViewById(R.id.arrow);

        }
    }
}

