package com.example.dinelink.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.dinelink.R;

public class LoginRolePage extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        getSupportActionBar().hide();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_role_page);

    }

    public void customerLogin (View view){

        Intent intent = new Intent(this, Customer_Login.class);
//        System.out.println("Clicked");
        startActivity(intent);
    }

    public void restaurantLogin (View view){

        Intent intent = new Intent(this, Restaurant_Login.class);
        startActivity(intent);
    }


}