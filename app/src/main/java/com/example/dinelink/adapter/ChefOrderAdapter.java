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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinelink.R;
import com.example.dinelink.model.Order;

import java.util.List;

public class ChefOrderAdapter extends ArrayAdapter<Order> {

    private Context context;
    private int resource;
    private List<Order> orderList;

    public ChefOrderAdapter(@NonNull Context context, int resource, List<Order> orderList) {
        super(context, resource,orderList);
        this.context=context;
        this.resource=resource;
        this.orderList=orderList;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null,false);

        TextView tableNoTextView = view.findViewById(R.id.tableNoTextView);
        Button viewOrderToggleBtn = view.findViewById(R.id.viewOrderToggleBtn);
        ListView viewOrderItemListView = view.findViewById(R.id.viewOrderItemListView);
        Button orderCompleteBtn = view.findViewById(R.id.orderCompleteBtn);
        TextView chefOrderItemTextView = view.findViewById(R.id.chefOrderItemTextView);
        TextView chefOrderQuantityTextView = view.findViewById(R.id.chefOrderQuantityTextView);
        ImageView chefOrderTopLine = view.findViewById(R.id.chefOrderTopLine);
        Order order = orderList.get(position);

        ChefOrderItemAdapter adapter = new ChefOrderItemAdapter(context, R.layout.chef_order_item_card,order.getOrderItemList());
        viewOrderItemListView.setAdapter(adapter);


// Get the number of items in the adapter
        int itemCount = order.getOrderItemList().size();

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





        tableNoTextView.setText("Table "+order.getTable());
        ChefOrderItemAdapter coiad = new ChefOrderItemAdapter(this.getContext(), R.layout.chef_order_item_card,order.getOrderItemList());
        viewOrderItemListView.setAdapter(coiad);
        notifyDataSetChanged();
        for(int i=0;i<order.getOrderItemList().size();i++)
        {
            System.out.println(order.getTable()+" "+order.getOrderItemList().get(i).getItem_name());
        }

        orderCompleteBtn.setVisibility(View.GONE);
        viewOrderItemListView.setVisibility(View.GONE);
        chefOrderItemTextView.setVisibility(View.GONE);
        chefOrderTopLine.setVisibility(View.GONE);
        chefOrderQuantityTextView.setVisibility(View.GONE);
        viewOrderToggleBtn.setText("view order");


        viewOrderToggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(orderCompleteBtn.getVisibility()==View.VISIBLE)
                {
                    orderCompleteBtn.setVisibility(View.GONE);
                    viewOrderItemListView.setVisibility(View.GONE);
                    chefOrderItemTextView.setVisibility(View.GONE);
                    chefOrderTopLine.setVisibility(View.GONE);
                    chefOrderQuantityTextView.setVisibility(View.GONE);
                    viewOrderToggleBtn.setText("view order");
                }
                else
                {
                    orderCompleteBtn.setVisibility(View.VISIBLE);
                    orderCompleteBtn.setVisibility(View.VISIBLE);
                    viewOrderItemListView.setVisibility(View.VISIBLE);
                    chefOrderItemTextView.setVisibility(View.VISIBLE);
                    chefOrderTopLine.setVisibility(View.VISIBLE);
                    chefOrderQuantityTextView.setVisibility(View.VISIBLE);
                    viewOrderToggleBtn.setText("hide order");
                }
            }
        });

        orderCompleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                orderList.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
