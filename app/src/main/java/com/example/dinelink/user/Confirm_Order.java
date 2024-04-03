package com.example.dinelink.user;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dinelink.adapter.OrderListAdapter;
import com.example.dinelink.R;
import com.example.dinelink.model.FoodItem;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Confirm_Order extends Activity {
    TextView Time,TotalAmount,GSTAmount,GrandTotalAmount;
    ListView orderView;
    List<FoodItem> orderList;
    private final DecimalFormat df = new DecimalFormat("0.00");
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order_layout);

        orderList = getIntent().getExtras().getParcelableArrayList("items");

        TotalAmount = findViewById(R.id.TotalAmount);
        GSTAmount = findViewById(R.id.GSTAmount);
        GrandTotalAmount = findViewById(R.id.GrandTotalAmount);
        Time = findViewById(R.id.Time);
        LocalTime t = LocalTime.now();
        String label = "Time: ";
        String colon = ":";
        Time.setText(":  "+t.getHour()+colon+t.getMinute());

        orderView = findViewById(R.id.OrderView);
        OrderListAdapter oa = new OrderListAdapter(this,R.layout.order_list_layout,this.orderList);
        orderView.setAdapter(oa);
        countTotal();
    }

//    protected void generateOrderList(){
//        FoodItem paneer = new FoodItem(11,2,"Paneer Tikka",210.0f,"Spicy Paneer Dish","Main Course","https://msubaroda.ac.in/asset/images/team/Foundermsu.jpg");
//        FoodItem naan = new FoodItem(12,2,"Butter naan",35.0f,"Bread type food","Main Course","https://msubaroda.ac.in/asset/images/team/Foundermsu.jpg");
//        FoodItem dal = new FoodItem(13,2,"Dal Fry",190.0f,"Dish of 4 different daals","Main Course","https://msubaroda.ac.in/asset/images/team/Foundermsu.jpg");
//        FoodItem rice = new FoodItem(13,2,"Jeera Rice",180.0f,"Rice with Jeera Tadka","Main Course","https://msubaroda.ac.in/asset/images/team/Foundermsu.jpg");
//        FoodItem raaita = new FoodItem(14,2,"Shahi Raaita",150.0f,"Salty and sour side dish","Main Course","https://msubaroda.ac.in/asset/images/team/Foundermsu.jpg");
//
//        paneer.setItemQuantity(1);
//        naan.setItemQuantity(13);
//        dal.setItemQuantity(2);
//        rice.setItemQuantity(2);
//        raaita.setItemQuantity(4);
//
//        orderList.add(paneer);
//        orderList.add(naan);
//        orderList.add(dal);
//        orderList.add(rice);
//        orderList.add(raaita);
//    }

    @SuppressLint("SetTextI18n")
    protected void countTotal(){
        double total = 0;
        for(FoodItem f : orderList){
            total += f.getItemQuantity() * f.getItemPrice();
        }
        double gst = total * 0.05;
        TotalAmount.setText(total+" ₹");
        GSTAmount.setText(df.format(gst)+" ₹");
        GrandTotalAmount.setText(String.valueOf(total+gst)+" ₹");
    }
}