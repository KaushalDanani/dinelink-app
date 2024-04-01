package com.example.dinelink.user;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.R;
import com.example.dinelink.adapter.MenuAdapter;
import com.example.dinelink.model.FoodItem;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuFilterBottomSheetFragment extends BottomSheetDialogFragment {

    Button filterPriceL2H;
    Button filterPriceH2L;

    MenuItemActivity menuItemActivity;

    MenuFilterBottomSheetFragment(MenuItemActivity menuItemActivity){
        this.menuItemActivity=menuItemActivity;
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_filter_bottom_layout, container, false);

        filterPriceL2H = view.findViewById(R.id.filterPriceL2H);
        filterPriceH2L = view.findViewById(R.id.filterPriceH2L);

        filterPriceL2H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<FoodItem> foodItemList = menuItemActivity.foodList;

                Collections.sort(foodItemList, new Comparator<FoodItem>() {
                    @Override
                    public int compare(FoodItem item1, FoodItem item2) {
                        return Float.compare(item1.getItemPrice(), item2.getItemPrice());
                    }
                });

                String category = menuItemActivity.categoryList.get(menuItemActivity.categoryList.indexOf(menuItemActivity.selectedCategory));
                menuItemActivity.categoryItemList.clear();
                for(FoodItem item : menuItemActivity.foodList)
                {
                    if(item.getItemCategory().equals(category))
                    {
                        menuItemActivity.categoryItemList.add(item);
                    }
                }


                MenuAdapter mad = new MenuAdapter(getContext(),R.layout.menu_item_card_layout,menuItemActivity.categoryItemList,menuItemActivity.menuItemsSelectedView);
                menuItemActivity.foodItemList.setAdapter(mad);


                dismiss();
            }
        });

        filterPriceH2L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<FoodItem> foodItemList = menuItemActivity.foodList;

                Collections.sort(foodItemList, new Comparator<FoodItem>() {
                    @Override
                    public int compare(FoodItem item1, FoodItem item2) {
                        return Float.compare(item2.getItemPrice(), item1.getItemPrice());
                    }
                });

                String category = menuItemActivity.categoryList.get(menuItemActivity.categoryList.indexOf(menuItemActivity.selectedCategory));
                menuItemActivity.categoryItemList.clear();
                for(FoodItem item : menuItemActivity.foodList)
                {
                    if(item.getItemCategory().equals(category))
                    {
                        menuItemActivity.categoryItemList.add(item);
                    }
                }


                MenuAdapter mad = new MenuAdapter(getContext(),R.layout.menu_item_card_layout,menuItemActivity.categoryItemList,menuItemActivity.menuItemsSelectedView);
                menuItemActivity.foodItemList.setAdapter(mad);


                dismiss();
            }
        });

        return view;

    }


}
