package com.example.dinelink.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.R;
import com.example.dinelink.model.FoodItem;

import java.util.List;

public class OrderListAdapter extends ArrayAdapter<FoodItem> {

    private List<FoodItem> Items;
    public OrderListAdapter(@NonNull Context context, int resource, @NonNull List<FoodItem> Items) {
        super(context, resource, Items);
        this.Items = Items;
    }

    @Nullable
    @Override
    public FoodItem getItem(int position) {
        return this.Items.get(position);
    }

    @SuppressLint({"SetTextI18n", "ViewHolder"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.order_list_layout,parent,false);
        FoodItem t = getItem(position);
        TextView ItemName = convertView.findViewById(R.id.ItemName);
        TextView ItemQty = convertView.findViewById(R.id.ItemQty);
        TextView ItemPrice = convertView.findViewById(R.id.ItemPrice);
        TextView ItemTotal = convertView.findViewById(R.id.ItemTotal);

//        assert t != null;
        ItemName.setText(t.getItem_name());
        ItemQty.setText(String.valueOf(t.getItem_quantity()));
        ItemPrice.setText(String.valueOf(t.getItem_price()));
        ItemTotal.setText(String.valueOf(t.getItem_price() * t.getItem_quantity()));

        return convertView;
    }
}
