package com.example.dinelink.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.model.ChefOrderItem;
import com.example.dinelink.R;

import java.util.List;

public class ChefOrderItemAdapter extends ArrayAdapter<ChefOrderItem> {

    private List<ChefOrderItem> orderItemList;
    private Context context;
    private int resource;
    public ChefOrderItemAdapter(@NonNull Context context, int resource, @NonNull List<ChefOrderItem> orderItemList) {
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

        ChefOrderItem orderItem = orderItemList.get(position);
        System.out.println(orderItem.getItem_name());
        chefOrderItemContentName.setText(orderItem.getItem_name());
        chefOrderItemContentQuantity.setText(""+orderItem.getItem_quantity());



        return view;
    }
}
