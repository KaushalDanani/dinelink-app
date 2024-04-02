
package com.example.dinelink.user;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;


import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinelink.adapter.CategoriesAdapter;
import com.example.dinelink.chef.ChefLayoutActivity;
import com.example.dinelink.model.FoodItem;
import com.example.dinelink.adapter.MenuAdapter;
import com.example.dinelink.R;
import com.example.dinelink.retrofit.MenuApi;
import com.example.dinelink.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuItemActivity extends Activity implements CategoriesAdapter.OnButtonClickListener {

	private LinearLayout ll;
	private Button foodItemCheckoutBtn;
	RecyclerView categoriesView;
	ListView foodItemList;
	TextView menuItemsSelectedView;
	CategoriesAdapter mAdapter;
	MenuAdapter menuAdapter;
	List<FoodItem> foodList = new ArrayList<>();
	Set<String> categories = new HashSet<>();
	List<String> categoryList = new ArrayList<String>();
	List<FoodItem> categoryItemList = new ArrayList<>();

	List<FoodItem> orderedItems = new ArrayList<>();
	private int hotelId;

	String selectedCategory;

		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_item_layout);
	
		ll = findViewById(R.id.ll);
		categoriesView = findViewById(R.id.categoriesView);
		foodItemList = findViewById(R.id.foodItemList);
		foodItemCheckoutBtn = findViewById(R.id.foodItemCheckoutBtn);
		menuItemsSelectedView=findViewById(R.id.menuItemsSelectedView);
		foodItemCheckoutBtn = findViewById(R.id.foodItemCheckoutBtn);

//		hotelId = getIntent().getIntExtra("HOTEL_ID",1);

		ll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				MenuFilterBottomSheetFragment bottomSheetFragment = new MenuFilterBottomSheetFragment(MenuItemActivity.this);
				bottomSheetFragment.show();


			}
		});

//		Checkout Button
		foodItemCheckoutBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				for(FoodItem item : foodList)
				{
					if(item.getItemQuantity()!=0)
					{
						orderedItems.add(item);
					}
				}

				System.out.println("asdf "+orderedItems.size());
				Intent ii = new Intent(MenuItemActivity.this, Confirm_Order.class);
				Bundle bb = new Bundle();
				bb.putParcelableArrayList("items",new ArrayList<>(orderedItems));
				ii.putExtras(bb);

				startActivity(ii);
			}
		});


			int hotelId = 1;
			RetrofitService retrofitService = new RetrofitService();
			MenuApi menuApi = retrofitService.getRetrofit().create(MenuApi.class);
			menuApi.getMenu(hotelId)
					.enqueue(new Callback<List<FoodItem>>() {
						@Override
						public void onResponse(Call<List<FoodItem>> call, Response<List<FoodItem>> response) {
							foodList=response.body();

							for(FoodItem item : foodList)
							{
								categories.add(""+item.getItemCategory());
							}

							categoryList=new ArrayList<>(categories);
							LinearLayoutManager mLayoutManager = new LinearLayoutManager(MenuItemActivity.this,LinearLayoutManager.HORIZONTAL,false);
							categoriesView.setLayoutManager(mLayoutManager);
							mAdapter = new CategoriesAdapter(MenuItemActivity.this,categoryList, MenuItemActivity.this);
							categoriesView.setAdapter(mAdapter);

							selectedCategory = categoryList.get(0);
							categoryItemList.clear();
							for(FoodItem item : foodList)
							{
								if(item.getItemCategory().equals(selectedCategory))
								{
									categoryItemList.add(item);
								}
							}


							MenuAdapter mad = new MenuAdapter(MenuItemActivity.this,R.layout.menu_item_card_layout,categoryItemList,menuItemsSelectedView);
							foodItemList.setAdapter(mad);

						}

						@Override
						public void onFailure(Call<List<FoodItem>> call, Throwable t) {
							Toast.makeText(MenuItemActivity.this, "Failed to load...", Toast.LENGTH_SHORT).show();
						}
					});
	}
//		Handle Button Click in Category view

		@Override
		public void onButtonClick(int position, Button categoryItemButton) {

			mAdapter.notifyDataSetChanged();
			selectedCategory = categoryList.get(position);

			categoryItemList.clear();
			for(FoodItem item : foodList)
			{
				if(item.getItemCategory().equals(selectedCategory))
				{
					categoryItemList.add(item);
				}
			}

			MenuAdapter mad = new MenuAdapter(MenuItemActivity.this,R.layout.menu_item_card_layout,categoryItemList,menuItemsSelectedView);
			foodItemList.setAdapter(mad);

		}

	}



	
	