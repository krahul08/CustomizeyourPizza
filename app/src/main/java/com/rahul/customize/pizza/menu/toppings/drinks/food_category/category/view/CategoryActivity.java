package com.rahul.customize.pizza.menu.toppings.drinks.food_category.category.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
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
    @BindView(R.id.pizzaImage)
    ImageView pizzaImage;
    @BindView(R.id.categoryImageLayout)
    RelativeLayout categoryImageLayout;
    @BindView(R.id.outerCircle)
    RelativeLayout outerCircle;
    @BindView(R.id.outerMainLayout)
    RelativeLayout outerMainLayout;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.relativeLayoutMain)
    RelativeLayout relativeLayoutMain;
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
    @BindView(R.id.innerCircleLayout)
    LinearLayout innerCircleLayout;
//    @BindView(R.id.circleImage1)
//    CircleImageView circleImage1;
//    @BindView(R.id.circleImage2)
//    CircleImageView circleImage2;
//    @BindView(R.id.circleImage3)
//    CircleImageView circleImage3;
//    @BindView(R.id.circleImage4)
//    CircleImageView circleImage4;
//    @BindView(R.id.circleImage5)
//    CircleImageView circleImage5;
//    @BindView(R.id.circleImage6)
//    CircleImageView circleImage6;

    @BindView(R.id.nestedView)
    NestedScrollView nestedView;
    @BindView(R.id.leftImage1)
    ImageView leftImage1;
    @BindView(R.id.leftImage2)
    ImageView leftImage2;
    @BindView(R.id.leftImage4)
    ImageView leftImage4;
    @BindView(R.id.leftImage5)
    ImageView leftImage5;
    @BindView(R.id.leftImage6)
    ImageView leftImage6;
    @BindView(R.id.leftImage7)
    ImageView leftImage7;
    @BindView(R.id.leftImage8)
    ImageView leftImage8;
    @BindView(R.id.leftImage9)
    ImageView leftImage9;
    @BindView(R.id.rightImage1)
    ImageView rightImage1;
    @BindView(R.id.rightImage2)
    ImageView rightImage2;
    @BindView(R.id.rightImage3)
    ImageView rightImage3;
    @BindView(R.id.rightImage5)
    ImageView rightImage5;
    @BindView(R.id.rightImage6)
    ImageView rightImage6;
    @BindView(R.id.rightImage7)
    ImageView rightImage7;
    @BindView(R.id.rightImage8)
    ImageView rightImage8;
    @BindView(R.id.rightImage9)
    ImageView rightImage9;
    @BindView(R.id.rightImage10)
    ImageView rightImage10;
    @BindView(R.id.rightImage11)
    ImageView rightImage11;
    @BindView(R.id.innerLeftLayout)
    RelativeLayout innerLeftLayout;
    @BindView(R.id.innerRightLayout)
    RelativeLayout innerRightLayout;



    private SelectedItemListAdapter selectedItemListAdapter;
    private FoodCategoryListAdapter categoryListAdapter;
    private SubCategoryListAdapter subCategoryListAdapter;
    private SubCategoryImageResponse subCategoryImageResponse;
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
        mRotationDetector = new RotationGestureDetector(this, categoryImageLayout);


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

        DraggableViewMain draggableViewMain = new DraggableViewMain(this, relativeLayoutMain);


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

        } catch (Exception e) {
            e.getMessage();
        }
        return super.onTouchEvent(event);
    }


    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);

        }
    }

    @Override
    public void getFoodCategory(CategoryResponse categoryResponse) {
        if (categoryResponse.isSuccess()) {

            if (categoryResponse.getCategory_list().size() != 0) {

                categoryListAdapter = new FoodCategoryListAdapter(this, this);
                categoryListAdapter.setData(categoryResponse.getCategory_list());
                categoryList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
                categoryList.setAdapter(categoryListAdapter);
                categoryList.setHasFixedSize(true);
                categoryListAdapter.notifyDataSetChanged();
            } else {
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
            if (subCategoryResponse.getSub_category_list().size() != 0) {
                subCategoryListAdapter = new SubCategoryListAdapter(this, this);
                subCategoryListAdapter.setData(subCategoryResponse.getSub_category_list());
                subCategoryList.setLayoutManager(new LinearLayoutManager(this));
                subCategoryList.setAdapter(subCategoryListAdapter);
                subCategoryList.setHasFixedSize(true);
                subCategoryListAdapter.notifyDataSetChanged();
            } else {
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

            if (subCategoryImageResponse.getSub_category_image_list().size() != 0) {

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
            } else {

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
        outerMainLayout.setRotation(angle);
        pizzaImage.setRotation(360 - angle);
        innerCircleLayout.setRotation(360 - angle);

    }

    @Override
    public int viewSelectedPosition(int position) {


        if (position == 0) {
//            circleImage1.setVisibility(View.VISIBLE);
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));

            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(0).getSub_category_image()).into(rightImage11);
        } else {
//            circleImage1.setVisibility(View.GONE);

        }
        if (position == 1) {
//            circleImage2.setVisibility(View.VISIBLE);
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));

            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(1).getSub_category_image()).into(rightImage11);
        } else {
//            circleImage2.setVisibility(View.GONE);
        }

        if (position == 2) {
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));

            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(2).getSub_category_image()).into(rightImage11);
//        }else {
//            circleImage3.setVisibility(View.GONE);
        }

        if (position == 3) {
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));

            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(3).getSub_category_image()).into(rightImage11);
        } else {
//            circleImage4.setVisibility(View.GONE);
        }

        if (position == 4) {

//            circleImage5.setVisibility(View.VISIBLE);
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));


            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(4).getSub_category_image()).into(rightImage11);
        } else {
//            circleImage5.setVisibility(View.GONE);
        }

        if (position == 5) {
//            circleImage6.setVisibility(View.VISIBLE);
            innerLeftLayout.setBackground(getResources().getDrawable(R.drawable.left_half_circle_design));
            innerRightLayout.setBackground(getResources().getDrawable(R.drawable.right_half_circle_design));

            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage1);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage2);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage7);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage4);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage5);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage6);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage8);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(leftImage9);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage1);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage2);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage3);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage5);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage6);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage7);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage8);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage9);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage10);
            Glide.with(this).load(imageListData.get(5).getSub_category_image()).into(rightImage11);
        } else {
//            circleImage6.setVisibility(View.GONE);
        }

        try {
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

        } catch (Exception e) {
            e.getMessage();
        }

        return position;
    }


}
