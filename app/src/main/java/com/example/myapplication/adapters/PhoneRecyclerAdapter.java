package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.listeners.OnPhoneRecyclerItemClickListener;

import java.util.ArrayList;

public class PhoneRecyclerAdapter extends RecyclerView.Adapter<PhoneRecyclerAdapter.ViewHolder> {

    private ArrayList<Phone> phoneArrayList;
    private OnPhoneRecyclerItemClickListener onPhoneRecyclerItemClickListener;

    public PhoneRecyclerAdapter(ArrayList<Phone> phoneArrayList) {
        this.phoneArrayList = phoneArrayList;
    }

    @NonNull
    @Override
    public PhoneRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPhoneRecyclerItemClickListener != null) {
                    onPhoneRecyclerItemClickListener.onItemClick(view, viewHolder.getAdapterPosition());
                }
            }

        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.namePhone.setText(phoneArrayList.get(position).getNamePhone());
        holder.ram.setText(phoneArrayList.get(position).getRam());
        if (position == phoneArrayList.size() - 1) {
            holder.divider.setVisibility(View.INVISIBLE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return phoneArrayList.size();
    }

    public void setListener(OnPhoneRecyclerItemClickListener listener) {
        this.onPhoneRecyclerItemClickListener = listener;
    }

    public ArrayList<Phone> getPhoneArrayList() {
        return phoneArrayList;
    }

    public void setItems(ArrayList<Phone> phoneArrayList) {
        this.phoneArrayList = phoneArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView namePhone;
        TextView ram;
        View divider;

        public ViewHolder(View view) {
            super(view);
            namePhone = view.findViewById(R.id.name_phone);
            ram = view.findViewById(R.id.ram);
            divider = view.findViewById(R.id.divider);

        }
    }

}
