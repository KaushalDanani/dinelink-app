
package com.example.dinelink.user;

import android.app.Activity;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinelink.adapter.CategoriesAdapter;
import com.example.dinelink.model.FoodItem;
import com.example.dinelink.adapter.MenuAdapter;
import com.example.dinelink.R;

import java.util.ArrayList;
import java.util.List;

	public class MenuItemActivity extends Activity implements CategoriesAdapter.OnButtonClickListener {

	private LinearLayout ll;
	private Button foodItemCheckoutBtn;
	private RecyclerView categoriesView;
	private ListView foodItemList;
	private TextView menuItemsSelectedView;
	CategoriesAdapter mAdapter;
	MenuAdapter menuAdapter;
	List<FoodItem> foodList = new ArrayList<>();


		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_item_layout);
	
		ll = findViewById(R.id.ll);
		categoriesView = findViewById(R.id.categoriesView);
		foodItemList = findViewById(R.id.foodItemList);
		foodItemCheckoutBtn = findViewById(R.id.foodItemCheckoutBtn);
		menuItemsSelectedView=findViewById(R.id.menuItemsSelectedView);

		ll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MenuItemActivity.this, "Pressed filter", Toast.LENGTH_SHORT).show();
			}
		});
		//custom code goes here


//		Categories View

		List<String> categories = new ArrayList<>();
		categories.add("aaa");
		categories.add("bbb");
		categories.add("ccc");
		categories.add("aaa");
		categories.add("bbb");
		categories.add("ccc");
		categories.add("aaa");
		categories.add("bbb");
		categories.add("ccc");
		categories.add("xxx");
		categories.add("bbb");
		categories.add("ccc");


		LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
		categoriesView.setLayoutManager(mLayoutManager);

		mAdapter = new CategoriesAdapter(MenuItemActivity.this,categories, this);
		categoriesView.setAdapter(mAdapter);


			FoodItem m1 = new FoodItem(1, 1, "Paneer Masala", 160, "Red Gravy", "Gravy", "");
			FoodItem m2 = new FoodItem(2, 2, "Paneer Butter Masala", 260, "Brown Gravy", "Gravy", "");

			foodList.add(m1);
			foodList.add(m2);

			MenuAdapter mad = new MenuAdapter(this,R.layout.menu_item_card_layout,foodList,menuItemsSelectedView);
			foodItemList.setAdapter(mad);

	}
//		Handle Button Click in Category view

		@Override
		public void onButtonClick(int position, Button categoryItemButton) {
			Toast.makeText(this, "click : "+position, Toast.LENGTH_SHORT).show();

			mAdapter.notifyDataSetChanged();

		}

		//	Adapter for menu display


	}



	
	