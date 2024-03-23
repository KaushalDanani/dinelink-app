
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		android_large___20
	 *	@date 		Tuesday 12th of March 2024 11:44:04 AM
	 *	@title 		Page 3
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.dinelink.chef;

import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.dinelink.R;
import com.example.dinelink.adapter.ChefOrderAdapter;
import com.example.dinelink.model.ChefOrderItem;
import com.example.dinelink.model.Order;

import java.util.ArrayList;
import java.util.List;

	public class ChefLayoutActivity extends AppCompatActivity {

	private List<Order> orderList = new ArrayList<>();
	private int table;

	ListView chefOrderListView;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chef_layout);

		chefOrderListView = findViewById(R.id.chefOrderListView);


		ChefOrderItem coi1 = new ChefOrderItem("Paneer Butter Masala",1);
		ChefOrderItem coi2 = new ChefOrderItem("Butter Roti",2);

		List<ChefOrderItem> orderItemList = new ArrayList<>();
		orderItemList.add(coi1);
		orderItemList.add(coi2);

		table=1;

		Order o1 = new Order(new ArrayList<>(orderItemList),table);

		ChefOrderItem coi3 = new ChefOrderItem("Jeera rice",1);
		orderItemList.add(coi3);

		table=2;
		Order o2 = new Order(new ArrayList<>(orderItemList),table);

		orderList.add(o1);
		orderList.add(o2);
		Order o3 = new Order(new ArrayList<>(orderItemList),3);
		orderList.add(o3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		orderItemList.add(coi3);
		Order o4 = new Order(new ArrayList<>(orderItemList),4);
		orderList.add(o4);

		ChefOrderAdapter coad = new ChefOrderAdapter(this,R.layout.chef_order_card,orderList);
		chefOrderListView.setAdapter(coad);
		//custom code goes here
	
	}
}
	
	