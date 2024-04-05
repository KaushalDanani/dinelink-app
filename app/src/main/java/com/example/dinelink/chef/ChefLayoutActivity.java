
package com.example.dinelink.chef;

import static android.content.Context.WIFI_SERVICE;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinelink.R;
import com.example.dinelink.adapter.ChefOrderAdapter;
import com.example.dinelink.model.FoodItem;
import com.example.dinelink.model.Orders;
import com.example.dinelink.retrofit.HotelApi;
import com.example.dinelink.retrofit.OrderApi;
import com.example.dinelink.retrofit.RetrofitService;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Handler;
import android.widget.Toast;



public class ChefLayoutActivity extends Activity {

	ListView chefOrderListView;

	private List<Orders> orderList;
	int hotelId=1;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.chef_layout);

		chefOrderListView = findViewById(R.id.chefOrderListView);

		SocketProgramming sp = new SocketProgramming(this,hotelId,orderList, chefOrderListView);


		Intent i1 = getIntent();
//		List<FoodItem> orderedItems = i1.getExtras().getParcelableArrayList("items");
		hotelId = i1.getIntExtra("hotel_id",1);

//		Toast.makeText(this, ""+hotelId, Toast.LENGTH_SHORT).show();

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
	

class SocketProgramming implements Runnable {

	Thread th;
	ChefLayoutActivity chefLayoutActivity;
	Handler handler;
	int hotelId;
	List<Orders> ordersList;
	ListView chefOrderListView;

	SocketProgramming(ChefLayoutActivity chefLayoutActivity,int hotelId, List<Orders> ordersList, ListView chefOrderListView) {
		this.chefLayoutActivity = chefLayoutActivity;
		this.hotelId=hotelId;
		this.chefOrderListView=chefOrderListView;
		this.ordersList=ordersList;
		th = new Thread(this);
		handler = new Handler(chefLayoutActivity.getMainLooper()); // Create a handler for the main UI thread
		System.out.println("CONS");
		th.start();
	}

	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(8388);
			WifiManager wifiManager = (WifiManager) chefLayoutActivity.getApplicationContext().getSystemService(WIFI_SERVICE);
			String ipAddress = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());

			RetrofitService retrofitService = new RetrofitService();
			HotelApi hotelApi = retrofitService.getRetrofit().create(HotelApi.class);
			hotelApi.setIp(ipAddress,hotelId)
					.enqueue(new Callback<Void>() {
						@Override
						public void onResponse(Call<Void> call, Response<Void> response) {
							handler.post(new Runnable() { // Post a Runnable to the main UI thread
								@Override
								public void run() {
									Toast.makeText(chefLayoutActivity, "IP Address stored", Toast.LENGTH_SHORT).show();
								}
							});
						}

						@Override
						public void onFailure(Call<Void> call, Throwable t) {
							handler.post(new Runnable() { // Post a Runnable to the main UI thread
								@Override
								public void run() {
									Toast.makeText(chefLayoutActivity, "IP Address update failed", Toast.LENGTH_SHORT).show();
								}
							});
						}
					});


			while (true) {
				handler.post(new Runnable() { // Post a Runnable to the main UI thread
					@Override
					public void run() {
						Toast.makeText(chefLayoutActivity, "Waiting for client : ip="+ipAddress, Toast.LENGTH_SHORT).show();
					}
				});
				System.out.println("Waiting for client");
				Socket s = ss.accept();

				handler.post(new Runnable() { // Post a Runnable to the main UI thread
					@Override
					public void run() {
						Toast.makeText(chefLayoutActivity, "Connection established", Toast.LENGTH_SHORT).show();
					}
				});

				SocketExecution se = new SocketExecution(chefLayoutActivity,s,ordersList,chefOrderListView);
			}
		} catch (Exception e) {
			System.out.println("SERVER : " + e.getMessage());
		}
	}
}

class SocketExecution implements Runnable{
		Thread th;
		ChefLayoutActivity chefLayoutActivity;
		Handler handler;
		Socket s;
		List<Orders> orderList;
		ObjectInputStream ois;
		ListView chefOrderListView;

		SocketExecution(ChefLayoutActivity chefLayoutActivity, Socket s, List<Orders> orderList, ListView chefOrderListView)
		{
			this.chefLayoutActivity=chefLayoutActivity;
			handler=new Handler(chefLayoutActivity.getMainLooper());
			this.orderList=orderList;
			this.chefOrderListView=chefOrderListView;
			th=new Thread(this);
			this.s=s;
			th.start();
		}

	@Override
	public void run() {
			try{
				ois = new ObjectInputStream(s.getInputStream());
				Orders newOrder = (Orders)ois.readObject();
				orderList.add(newOrder);

				ChefOrderAdapter coad = new ChefOrderAdapter(chefLayoutActivity,R.layout.chef_order_card,orderList);
				chefOrderListView.setAdapter(coad);


				handler.post(new Runnable() {
					@Override
					public void run() {
						Toast.makeText(chefLayoutActivity, ""+newOrder.getOrderId(), Toast.LENGTH_SHORT).show();
					}
				});
			}
			catch (Exception e)
			{
				System.out.println("SERVER EXECUTION : "+e.getMessage());
			}
	}
}



