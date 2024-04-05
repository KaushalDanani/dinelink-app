package com.example.dinelink.user;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dinelink.BuildConfig;
import com.example.dinelink.adapter.OrderListAdapter;
import com.example.dinelink.R;
import com.example.dinelink.login.Customer_Login;
import com.example.dinelink.model.FoodItem;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Confirm_Order extends Activity implements PaymentResultListener {
    TextView Time,TotalAmount,GSTAmount,GrandTotalAmount;
    ListView orderView;
    List<FoodItem> orderList;
    Button confirmOrderBtn;
    private static double total, gst;
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
        confirmOrderBtn = findViewById(R.id.confirmOrderBtn);
        Time = findViewById(R.id.Time);

        LocalTime t = LocalTime.now();
        String colon = ":";
        Time.setText(":  " + t.getHour() + colon + t.getMinute());

        orderView = findViewById(R.id.OrderView);
        OrderListAdapter oa = new OrderListAdapter(this,R.layout.order_list_layout,this.orderList);
        orderView.setAdapter(oa);
        countTotal();

        Checkout.preload(getApplicationContext());

        confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payWithRazorpay();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    protected void countTotal(){
        total = 0;
        for(FoodItem f : orderList){
            total += f.getItemQuantity() * f.getItemPrice();
        }
        gst = total * 0.05;
        TotalAmount.setText(total+" ₹");
        GSTAmount.setText(df.format(gst)+" ₹");
        GrandTotalAmount.setText(String.valueOf(total+gst)+" ₹");
    }

    private void payWithRazorpay() {
        Checkout checkout = new Checkout();
        checkout.setKeyID(BuildConfig.PAYMENT_KEY_ID);

        checkout.setImage(R.drawable.dinelink_app_icon);

        try {
            JSONObject options = new JSONObject();

            options.put("name", "DineLink");
            options.put("description", "Reference No. #123456");
//            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
//            options.put("order_id", "order_DBJOWzybf0sJbb"); //from response of step 3.
            options.put("theme.color", "#ff0000");
            options.put("currency", "INR");
            options.put("amount", ""+((total+gst)*100));
            options.put("prefill.email", Customer_Login.USER_EMAIL_ID);
            options.put("prefill.contact",QRCodeScanner.USER_PHONE_NO);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 3);
            options.put("retry", retryObj);

            checkout.open(Confirm_Order.this, options);

        } catch(Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
        }
    }

    @Override
    public void onPaymentSuccess(String pay_id) {


        // Jay P Code, Networking

        startActivity(new Intent(Confirm_Order.this, QRCodeScanner.class));
    }

    @Override
    public void onPaymentError(int c, String res) {

        Toast.makeText(this, "ERROR "+c+" : "+res, Toast.LENGTH_SHORT).show();

        Intent ii = new Intent(Confirm_Order.this, Confirm_Order.class);
        Bundle bb = new Bundle();
        bb.putParcelableArrayList("items",new ArrayList<>(orderList));
        ii.putExtras(bb);
        startActivity(ii);
    }
}