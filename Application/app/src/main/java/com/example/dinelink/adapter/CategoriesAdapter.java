package com.example.dinelink.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinelink.R;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder>
{
    private List<String> stringList;
    private Context context;
    private OnButtonClickListener listener;
    private static int selectedPosition = 0;


    public CategoriesAdapter(Context context, List<String> stringList, OnButtonClickListener listener) {
        this.context = context;
        this.stringList = stringList;
        this.listener=listener;


    }

    @NonNull
    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.ViewHolder holder, int position) {
        String string = stringList.get(position);
        holder.categoryItemButton.setText(string);

        if (position == selectedPosition) {
            // If selected, set background color and text color
            holder.categoryItemButton.setBackgroundResource(R.drawable.rectangle_24_shape);
            holder.categoryItemButton.setTextColor(Color.BLACK);
        } else {
            // If not selected, remove background color and set default text color
            holder.categoryItemButton.setBackgroundResource(android.R.color.transparent);
            holder.categoryItemButton.setTextColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return stringList.size();

    }

    public interface OnButtonClickListener {
        void onButtonClick(int position, Button categoryItemButton);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button categoryItemButton;

        public ViewHolder(@NonNull View itemView, final OnButtonClickListener listener) {
            super(itemView);
            categoryItemButton = itemView.findViewById(R.id.categoryItemButton);

            categoryItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            selectedPosition = position;
                            if (listener != null) {
                                listener.onButtonClick(position,categoryItemButton);
                            }
                        }
                    }




                }
            });
        }
    }
}
