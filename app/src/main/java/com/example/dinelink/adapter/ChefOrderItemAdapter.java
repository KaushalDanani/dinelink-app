package com.example.dinelink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.model.FoodItem;
import com.example.dinelink.model.OrderItem;
import com.example.dinelink.R;
import com.example.dinelink.retrofit.MenuApi;
import com.example.dinelink.retrofit.OrderItemApi;
import com.example.dinelink.retrofit.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChefOrderItemAdapter extends ArrayAdapter<OrderItem> {

    private List<OrderItem> orderItemList;
    private Context context;
    private int resource;
    public ChefOrderItemAdapter(@NonNull Context context, int resource, @NonNull List<OrderItem> orderItemList) {
        super(context, resource, orderItemList);

        this.context=context;
        this.resource=resource;
        this.orderItemList=orderItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null,false);

        TextView chefOrderItemContentName = view.findViewById(R.id.chefOrderItemContentName);
        TextView chefOrderItemContentQuantity = view.findViewById(R.id.chefOrderItemContentQuantity);

        OrderItem orderItem = orderItemList.get(position);

        RetrofitService retrofitService = new RetrofitService();
        MenuApi menuApi = retrofitService.getRetrofit().create(MenuApi.class);
       menuApi.getOrderItemByItemId(orderItem.getItemId())
               .enqueue(new Callback<FoodItem>() {
                   @Override
                   public void onResponse(Call<FoodItem> call, Response<FoodItem> response) {
                       FoodItem item = response.body();
                       chefOrderItemContentName.setText(""+item.getItemName());
                       chefOrderItemContentQuantity.setText(""+orderItem.getItemQuantity());
                   }

                   @Override
                   public void onFailure(Call<FoodItem> call, Throwable t) {

                   }
               });

//        System.out.println(orderItem.getItem_name());




        return view;
    }
}
