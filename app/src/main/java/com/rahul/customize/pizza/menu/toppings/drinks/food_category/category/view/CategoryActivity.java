package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.dragable_views.DraggableViewMain;
import com.app.dragable_views.OnViewSelection;
import com.bumptech.glide.Glide;
import com.rahul.customize.pizza.menu.toppings.drinks.R;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.CategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SelectedItemData;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageListData;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryImageResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.model.SubCategoryResponse;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.presenter.CategoryPresenter;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.presenter.CategoryPresenterImpl;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.provider.CategoryProviderImpl;
import com.rahul.customize.pizza.menu.toppings.drinks.food_category.helper.RotationGestureDetector;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements CategoryViews, RotationGestureDetector.OnRotationGestureListener, OnViewSelection {

    @BindView(R.id.categoryList)
    RecyclerView categoryList;
    @BindView(R.id.subCategoryList)
    RecyclerView subCategoryList;
    //    @BindView(R.id.subCategoryName)
//    TextView subCategoryName;
//    @BindView(R.id.back)
//    TextView back;
//    @BindView(R.id.categoryImage)
//    ImageView categoryImage;
    @BindView(R.id.categoryImageLayout)
    RelativeLayout categoryImageLayout;
    @BindView(R.id.outerCircle)
    RelativeLayout outerCircle;
    @BindView(R.id.outerMainLayout)
    RelativeLayout outerMainLayout;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.image1Text)
    TextView image1Text;
    @BindView(R.id.image1Layout)
    RelativeLayout image1Layout;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image2Text)
    TextView image2Text;
    @BindView(R.id.image2Layout)
    RelativeLayout image2Layout;
    @BindView(R.id.image3Text)
    TextView image3Text;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image3Layout)
    RelativeLayout image3Layout;
    @BindView(R.id.image4)
    ImageView image4;
    @BindView(R.id.image4Text)
    TextView image4Text;
    @BindView(R.id.image4Layout)
    RelativeLayout image4Layout;
    @BindView(R.id.image5)
    ImageView image5;
    @BindView(R.id.image5Text)
    TextView image5Text;
    @BindView(R.id.image5Layout)
    RelativeLayout image5Layout;
    @BindView(R.id.image6)
    ImageView image6;
    @BindView(R.id.image6Text)
    TextView image6Text;
    @BindView(R.id.image6Layout)
    RelativeLayout image6Layout;
    @BindView(R.id.foodItemNameLabel)
    TextView foodItemNameLabel;
    @BindView(R.id.selectedItemList)
    RecyclerView selectedItemList;
    @BindView(R.id.foodItemName)
    TextView foodItemName;
    @BindView(R.id.foodItemLabelLayout)
    LinearLayout foodItemLabelLayout;
    @BindView(R.id.foodItemDescription)
    TextView foodItemDescription;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.submitLayout)
    LinearLayout submitLayout;
    private SelectedItemListAdapter selectedItemListAdapter;
    private FoodCategoryListAdapter categoryListAdapter;
    private SubCategoryListAdapter subCategoryListAdapter;
    private CategoryPresenter categoryPresenter;
    private int categoryId;
    private RotationGestureDetector mRotationDetector;
    private List<SubCategoryImageListData> imageListData;
    private ArrayList<String> itemsArrayList = new ArrayList<String>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        categoryPresenter = new CategoryPresenterImpl(this, new CategoryProviderImpl());
        categoryPresenter.getCategoryList();
        mRotationDetector = new RotationGestureDetector(this, outerMainLayout);


//
        implementEvents();

        outerMainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                float angle = mRotationDetector.getAngle();
//        categoryImage.setRotation(angle);
                return false;
            }
        });
    }

    private void implementEvents() {

        DraggableViewMain draggableViewMain = new DraggableViewMain(this, outerCircle);


        draggableViewMain.addView(image1Layout);
        draggableViewMain.addView(image2Layout);
        draggableViewMain.addView(image3Layout);
        draggableViewMain.addView(image4Layout);
        draggableViewMain.addView(image5Layout);
        draggableViewMain.addView(image6Layout);

//        image1Layout.setOnLongClickListener(this);
//        image2Layout.setOnLongClickListener(this);
//        image3Layout.setOnLongClickListener(this);
//        image4Layout.setOnLongClickListener(this);
//        image5Layout.setOnLongClickListener(this);
//        image6Layout.setOnLongClickListener(this);
//
//        categoryImageLayout.setOnDragListener(this);
    }


//    @Override
//    public boolean onDrag(View view, DragEvent event) {
//        action = event.getAction();
//
//        switch (action) {
//            case DragEvent.ACTION_DRAG_STARTED:
//
//                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//
//                    //  view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
//
//                    // Invalidate the view to force a redraw in the new tint
//                    //  view.invalidate();
//
//                    return true;
//
//                }
//                return false;
//
//            case DragEvent.ACTION_DRAG_ENTERED:
//
//                view.invalidate();
//                return true;
//
//            case DragEvent.ACTION_DRAG_EXITED:
//
//                view.getBackground().clearColorFilter();
//                view.invalidate();
//                return true;
//
//            case DragEvent.ACTION_DROP:
//
//               try {
//                   View v = (View) event.getLocalState();
//                   ViewGroup owner = (ViewGroup) view.getParent();
//                   owner.removeView(view);
//                   if(view instanceof RelativeLayout){
//                       RelativeLayout container = (RelativeLayout) view;
//                       container.addView(v);
//
//                       v.setBackgroundColor(Color.TRANSPARENT);
//
//
//                   }
//               }catch (Exception e){
//                   e.printStackTrace();
//               }
//
//                return true;
//
//            case DragEvent.ACTION_DRAG_ENDED:
//                // Turns off any color tinting
//                view.getBackground().clearColorFilter();
//
//                // Invalidates the view to force a redraw
//                view.invalidate();
//
//                // Does a getResult(), and displays what happened.
//                if (event.getResult())
//                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
//
//                else
//                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
//
//
//                // returns true; the value is ignored.
//                return true;
//
//            // An unknown action type was received.
//            default:
//                Log.d("newissue","Unknown action type received by OnDragListener.");
////                Log.e("DragDrop Example", "`");
//                break;
//        }
//
//
//        return false;
//    }

//    @Override
//    public boolean onLongClick(View v) {
//
//        ClipData.Item item = new ClipData.Item((String)v.getTag());
////        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
//
//        ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
//        View.DragShadowBuilder myShadow = new View.DragShadowBuilder(image1);
//
//        v.startDrag(dragData,myShadow,null,0);
//
//        v.setVisibility(View.INVISIBLE);
//
//
//        return true;
//

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            mRotationDetector.onTouchEvent(event);

        }catch (Exception e){
            e.getMessage();
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void showProgress(boolean show) {
        if (show){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);

        }
    }

    @Override
    public void getFoodCategory(CategoryResponse categoryResponse) {
        if (categoryResponse.isSuccess()) {

            if (categoryResponse.getCategory_list().size()!=0){

            categoryListAdapter = new FoodCategoryListAdapter(this, this);
            categoryListAdapter.setData(categoryResponse.getCategory_list());
            categoryList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
            categoryList.setAdapter(categoryListAdapter);
            categoryList.setHasFixedSize(true);
            categoryListAdapter.notifyDataSetChanged();
        }else {
                foodItemLabelLayout.setVisibility(View.GONE);
                outerMainLayout.setVisibility(View.GONE);
                submitLayout.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void getSubCategory(SubCategoryResponse subCategoryResponse) {
        if (subCategoryResponse.isSuccess()) {
            subCategoryList.setVisibility(View.VISIBLE);
            if (subCategoryResponse.getSub_category_list().size()!=0){
            subCategoryListAdapter = new SubCategoryListAdapter(this, this);
            subCategoryListAdapter.setData(subCategoryResponse.getSub_category_list());
            subCategoryList.setLayoutManager(new LinearLayoutManager(this));
            subCategoryList.setAdapter(subCategoryListAdapter);
            subCategoryList.setHasFixedSize(true);
            subCategoryListAdapter.notifyDataSetChanged();
        }else {
                foodItemLabelLayout.setVisibility(View.GONE);
                outerMainLayout.setVisibility(View.GONE);
                submitLayout.setVisibility(View.GONE);
                subCategoryList.setVisibility(View.GONE);
            }

        }
    }
    @Override
    public void getSubCategoryImages(SubCategoryImageResponse subCategoryImageResponse) {
        if (subCategoryImageResponse.isSuccess()) {
            this.imageListData = subCategoryImageResponse.getSub_category_image_list();

            if (subCategoryImageResponse.getSub_category_image_list().size()!=0){

                foodItemLabelLayout.setVisibility(View.VISIBLE);
                outerMainLayout.setVisibility(View.VISIBLE);
                submitLayout.setVisibility(View.VISIBLE);

                foodItemName.setText("Pan Pizza");
                foodItemDescription.setText(subCategoryImageResponse.getSub_category_description());
                foodItemNameLabel.setText("Pan Pizza");

//            for (int i=0; i<subCategoryImageResponse.getSub_category_image_list().size();i++){

                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(0).getSub_category_image()).into(image1);
                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(1).getSub_category_image()).into(image2);
                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(2).getSub_category_image()).into(image3);
                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(3).getSub_category_image()).into(image4);
                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(4).getSub_category_image()).into(image5);
                Glide.with(this).load(subCategoryImageResponse.getSub_category_image_list().get(5).getSub_category_image()).into(image6);

                image1Text.setText(subCategoryImageResponse.getSub_category_image_list().get(0).getImage_name());
                image2Text.setText(subCategoryImageResponse.getSub_category_image_list().get(1).getImage_name());
                image3Text.setText(subCategoryImageResponse.getSub_category_image_list().get(2).getImage_name());
                image4Text.setText(subCategoryImageResponse.getSub_category_image_list().get(3).getImage_name());
                image5Text.setText(subCategoryImageResponse.getSub_category_image_list().get(4).getImage_name());
                image6Text.setText(subCategoryImageResponse.getSub_category_image_list().get(5).getImage_name());
            }else {

                foodItemLabelLayout.setVisibility(View.GONE);
                outerMainLayout.setVisibility(View.GONE);
                submitLayout.setVisibility(View.GONE);
            }
        }
    }
    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    public void ShowSubCategoryList(int categoryId) {
        this.categoryId = categoryId;
        categoryPresenter.getSubCategoryList(categoryId);
    }

    public void showSubCategoryImages(int subCategoryId) {
        categoryPresenter.getSubCategoryImage(subCategoryId);
    }

    @Override
    public void onRotation(RotationGestureDetector rotationDetector) {
        float angle = rotationDetector.getAngle();
        outerMainLayout.setRotation(outerMainLayout.getRotation() - angle);
    }

    @Override
    public int viewSelectedPosition(int position) {

        itemsArrayList.add(imageListData.get(position).getImage_name());
        //selectedItemData.setItemName(imageListData.get(position).getImage_name());

        selectedItemListAdapter = new SelectedItemListAdapter(this);
        selectedItemListAdapter.setData(itemsArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        selectedItemList.setLayoutManager(layoutManager);
        selectedItemList.setHasFixedSize(true);
        selectedItemList.setAdapter(selectedItemListAdapter);
        selectedItemListAdapter.notifyDataSetChanged();
        selectedItemList.setNestedScrollingEnabled(false);



        return position;
    }
}
