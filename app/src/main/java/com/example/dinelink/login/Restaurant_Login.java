package com.example.dinelink.login;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dinelink.R;
import com.example.dinelink.chef.ChefLayoutActivity;
import com.example.dinelink.model.Hotel;
import com.example.dinelink.retrofit.HotelApi;
import com.example.dinelink.retrofit.RetrofitService;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Restaurant_Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
//        EdgeToEdge.enable(this);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.restaurantloginpage), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        setContentView(R.layout.activity_restaurant_login);

//        Intent intent = getIntent();

       initializeComponent();

    }

    public void initializeComponent(){
        EditText input_hotel_id = findViewById(R.id.restaurant_id);
        EditText input_hotel_password = findViewById(R.id.restaurant_password);
        Button login = findViewById(R.id.restaurant_login);

        RetrofitService retrofitService = new RetrofitService();
        HotelApi hotelApi = retrofitService.getRetrofit().create(HotelApi.class);

        login.setOnClickListener(view -> {

            String hotel_id = String.valueOf(input_hotel_id.getText());
            String hotel_password = String.valueOf(input_hotel_password.getText());

            hotelApi.getAllHotel().enqueue(new Callback<List<Hotel>>() {
                @Override
                public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                    if (response.isSuccessful()) {
                        List<Hotel> allHotel = response.body();
                        int flag = 0;

                        for (Hotel h : allHotel) {
                            if((h.getHotel_id()+"").equals(hotel_id) && h.getHote_password().equals(hotel_password)){
                                flag = 1;
                                break;
                            }
                        }

                        System.out.println(flag);

                        if(flag == 1){
                            Toast.makeText(Restaurant_Login.this,"Login Successful!",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Restaurant_Login.this, ChefLayoutActivity.class);
                            i.putExtra("hotel_id",Integer.parseInt(hotel_id));
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(Restaurant_Login.this,"Login Denied",Toast.LENGTH_SHORT).show();
                        }


                        // Handle the list of hotels
                    } else {
                        // Handle unsuccessful response
                        Toast.makeText(Restaurant_Login.this,"Server Connection Error",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Hotel>> call, Throwable t) {
                    // Handle network call failure
                    System.out.println(t.getMessage());
                    Toast.makeText(Restaurant_Login.this,"Network Error",Toast.LENGTH_SHORT).show();
                }
            });


        });

    }
}