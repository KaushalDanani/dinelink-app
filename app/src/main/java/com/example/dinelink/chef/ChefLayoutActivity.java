
package com.example.dinelink.chef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinelink.R;
import com.example.dinelink.adapter.ChefOrderAdapter;
import com.example.dinelink.model.FoodItem;
import com.example.dinelink.model.Orders;
import com.example.dinelink.retrofit.OrderApi;
import com.example.dinelink.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class ChefLayoutActivity extends Activity {


	ListView chefOrderListView;

	private List<Orders> orderList;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chef_layout);

		chefOrderListView = findViewById(R.id.chefOrderListView);

		int hotelId=1;

		Intent i1 = getIntent();
		List<FoodItem> orderedItems = i1.getExtras().getParcelableArrayList("items");

		Toast.makeText(this, ""+orderedItems.size(), Toast.LENGTH_SHORT).show();

		RetrofitService retrofitService = new RetrofitService();
		OrderApi orderApi = retrofitService.getRetrofit().create(OrderApi.class);
		orderApi.getOrders(hotelId)
				.enqueue(new Callback<List<Orders>>() {
					@Override
					public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
						orderList=response.body();



						ChefOrderAdapter coad = new ChefOrderAdapter(ChefLayoutActivity.this,R.layout.chef_order_card,orderList);
						chefOrderListView.setAdapter(coad);

					}

					@Override
					public void onFailure(Call<List<Orders>> call, Throwable t) {
						Toast.makeText(ChefLayoutActivity.this, "Orders Failed to load...", Toast.LENGTH_SHORT).show();
					}
				});



	}
}
	
	