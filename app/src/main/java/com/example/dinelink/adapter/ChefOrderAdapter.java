package com.example.dinelink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.R;
import com.example.dinelink.model.OrderItem;
import com.example.dinelink.model.Orders;
import com.example.dinelink.retrofit.OrderItemApi;
import com.example.dinelink.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChefOrderAdapter extends ArrayAdapter<Orders> {

    private Context context;
    private int resource;
    private List<Orders> orderList;

    RetrofitService retrofitService = new RetrofitService();
    OrderItemApi orderItemApi = retrofitService.getRetrofit().create(OrderItemApi.class);

    public ChefOrderAdapter(@NonNull Context context, int resource, List<Orders> orderList) {
        super(context, resource, orderList);
        this.context = context;
        this.resource = resource;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, null, false);

        TextView tableNoTextView = view.findViewById(R.id.tableNoTextView);
        Button viewOrderToggleBtn = view.findViewById(R.id.viewOrderToggleBtn);
        ListView viewOrderItemListView = view.findViewById(R.id.viewOrderItemListView);
        Button orderCompleteBtn = view.findViewById(R.id.orderCompleteBtn);
        TextView chefOrderItemTextView = view.findViewById(R.id.chefOrderItemTextView);
        TextView chefOrderQuantityTextView = view.findViewById(R.id.chefOrderQuantityTextView);
        ImageView chefOrderTopLine = view.findViewById(R.id.chefOrderTopLine);
        Orders order = orderList.get(position);

        // Set table number
        tableNoTextView.setText("Table " + order.getTableNo());

        // Set up button click listener
        viewOrderToggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleOrderView(viewOrderItemListView, orderCompleteBtn, chefOrderItemTextView, chefOrderQuantityTextView, viewOrderToggleBtn, chefOrderTopLine);
            }
        });

        // Set up order completion button click listener
        orderCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeOrder(position);
            }
        });

        // Initially hide order items and completion button
        toggleOrderView(viewOrderItemListView, orderCompleteBtn, chefOrderItemTextView, chefOrderQuantityTextView, viewOrderToggleBtn, chefOrderTopLine);

        // Fetch order items asynchronously
        fetchOrderItems(order.getOrderId(), viewOrderItemListView);

        return view;
    }

    // Method to toggle visibility of order items and completion button
    private void toggleOrderView(ListView viewOrderItemListView, Button orderCompleteBtn, TextView chefOrderItemTextView,
                                 TextView chefOrderQuantityTextView, Button viewOrderToggleBtn, ImageView chefOrderTopLine) {
        int visibility = viewOrderItemListView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
        viewOrderItemListView.setVisibility(visibility);
        orderCompleteBtn.setVisibility(visibility);
        chefOrderItemTextView.setVisibility(visibility);
        chefOrderQuantityTextView.setVisibility(visibility);
        chefOrderTopLine.setVisibility(visibility);
        viewOrderToggleBtn.setText(visibility == View.VISIBLE ? "Hide Order" : "View Order");
    }

    // Method to remove order from the list
    private void removeOrder(int position) {
        orderList.remove(position);
        notifyDataSetChanged();
    }

    // Method to fetch order items asynchronously
    private void fetchOrderItems(int orderId, ListView viewOrderItemListView) {
        orderItemApi.getOrderItems(orderId).enqueue(new Callback<List<OrderItem>>() {
            @Override
            public void onResponse(Call<List<OrderItem>> call, Response<List<OrderItem>> response) {
                if (response.isSuccessful()) {
                    List<OrderItem> orderItemList = response.body();
                    if (orderItemList != null && !orderItemList.isEmpty()) {

                        // Update ListView with fetched order items
                        ChefOrderItemAdapter adapter = new ChefOrderItemAdapter(context, R.layout.chef_order_item_card, orderItemList);
                        viewOrderItemListView.setAdapter(adapter);

                        // Get the number of items in the adapter
                        int itemCount = orderItemList.size();

                        // Calculate total height of all items
                        int totalHeight = 0;
                        for (int i = 0; i < itemCount; i++) {
                            View listItem = viewOrderItemListView.getAdapter().getView(i, null, viewOrderItemListView);
                            listItem.measure(0, 0);
                            totalHeight += listItem.getMeasuredHeight();
                        }

                        // Adjust the height of the ListView
                        ViewGroup.LayoutParams params = viewOrderItemListView.getLayoutParams();
                        params.height = 90*(itemCount);
                        viewOrderItemListView.setLayoutParams(params);
                        viewOrderItemListView.requestLayout();

//                        ChefOrderItemAdapter coiad = new ChefOrderItemAdapter(ChefOrderAdapter.this.getContext(), R.layout.chef_order_item_card,orderItemList);
//                        viewOrderItemListView.setAdapter(coiad);
//                        notifyDataSetChanged();


                        // Update ListView with fetched order items
                        adapter = new ChefOrderItemAdapter(context, R.layout.chef_order_item_card, orderItemList);
                        viewOrderItemListView.setAdapter(adapter);
                    }
                } else {
                    Toast.makeText(context, "Failed to load order items", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<OrderItem>> call, Throwable t) {
                Toast.makeText(context, "Failed to load order items", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
