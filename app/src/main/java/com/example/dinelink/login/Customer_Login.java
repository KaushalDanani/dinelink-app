package com.example.dinelink.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.dinelink.R;
import com.example.dinelink.user.QRCodeScanner;

public class Customer_Login extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customer_login);

//        Intent intent = getIntent();
    }

    public void SignIn_With_Google (View view) {
        Intent ii = new Intent(this, QRCodeScanner.class);
        startActivity(ii);
    }

}