package com.example.dinelink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.model.FoodItem;
import com.example.dinelink.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<FoodItem> {
    Context context;
    List<FoodItem> foodList;
    TextView menuItemsSelectedView;
    int resource;



    public MenuAdapter(@NonNull Context context, int resource, @NonNull List<FoodItem> foodList, TextView menuItemsSelectedView) {
        super(context, resource, foodList);
        this.context=context;
        this.foodList=foodList;
        this.resource=resource;
        this.menuItemsSelectedView=menuItemsSelectedView;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null,false);

        FoodItem item = foodList.get(position);

        TextView foodItemName = view.findViewById(R.id.foodItemName);
        TextView foodItemPrice = view.findViewById(R.id.foodItemPrice);
        TextView foodItemDesc = view.findViewById(R.id.foodItemDesc);
        TextView foodItemQuantity = view.findViewById(R.id.foodItemQuantity);
        ImageView foodItemImage = view.findViewById(R.id.foodItemImage);
        Button foodItemPlusBtn = view.findViewById(R.id.foodItemPlusBtn);
        Button foodItemMinusBtn = view.findViewById(R.id.foodItemMinusBtn);

        foodItemName.setText(item.getItemName());
        foodItemPrice.setText("₹ "+item.getItemPrice());
        foodItemDesc.setText(item.getItemDesc());
        foodItemQuantity.setText(""+item.getItemQuantity());
        foodItemPlusBtn.setText("+");
        foodItemMinusBtn.setText("-");

        String imageUrl = "https://example.com/image.jpg";
        Picasso.get().load(imageUrl).into(foodItemImage);

        foodItemPlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int q=Integer.parseInt(foodItemQuantity.getText().toString());

                    String itemsSelected = menuItemsSelectedView.getText().toString();

                    int prevQ = Integer.parseInt(itemsSelected.substring(0,itemsSelected.indexOf(' ')));
                    int finalQ = prevQ+1;
                    if(finalQ==1)
                    {
                        menuItemsSelectedView.setText(""+finalQ + " item selected");
                    }
                    else
                    {
                        menuItemsSelectedView.setText(""+finalQ + " items selected");
                    }


                foodItemQuantity.setText(""+(q+1));
                item.setItemQuantity(q+1);
            }
        });

        foodItemMinusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int q=Integer.parseInt(foodItemQuantity.getText().toString());
                if(q>0)
                {
                    String itemsSelected = menuItemsSelectedView.getText().toString();

                    int prevQ = Integer.parseInt(itemsSelected.substring(0,itemsSelected.indexOf(' ')));
                    int finalQ = prevQ-1;
                    if(finalQ==1)
                    {
                        menuItemsSelectedView.setText(""+finalQ + " item selected");
                    }
                    else
                    {
                        menuItemsSelectedView.setText(""+finalQ + " items selected");
                    }


                    foodItemQuantity.setText(""+(q-1));
                    item.setItemQuantity(q-1);

                }
            }
        });


        return view;
    }
}
