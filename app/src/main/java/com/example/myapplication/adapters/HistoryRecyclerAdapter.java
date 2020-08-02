package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;

import java.util.ArrayList;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.ViewHolder> {
    private ArrayList<String> historyList;
    private Context context;
    private OnCountryRecyclerItemClickListener listener;

    public HistoryRecyclerAdapter(ArrayList<String> historyList, Context context, OnCountryRecyclerItemClickListener listener) {
        this.context = context;
        this.historyList = historyList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HistoryRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_item, parent, false);
        final HistoryRecyclerAdapter.ViewHolder viewHolder = new HistoryRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    public void setListener(OnCountryRecyclerItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(historyList.get(position));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(v, holder.getAdapterPosition());
                }
            }
        });
        if (position == historyList.size() - 1) {
            holder.divider.setVisibility(View.INVISIBLE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (historyList != null)
            return historyList.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View divider;
        AppCompatTextView textView;
        View container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            divider = itemView.findViewById(R.id.divider_history);
            textView = itemView.findViewById(R.id.request_text);
            container = itemView;
        }
    }
}
