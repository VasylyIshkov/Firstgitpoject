package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestBuilder;
import com.example.myapplication.R;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;
import com.example.myapplication.svg.GlideApp;
import com.example.myapplication.svg.SvgSoftwareLayerSetter;

import java.util.ArrayList;

import static android.util.Log.DEBUG;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountyRecyclerAdapter extends RecyclerView.Adapter<CountyRecyclerAdapter.ViewHolder> {

    private ArrayList<CountryItem> countryItems;
    private OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener;
    Context context;

    public CountyRecyclerAdapter(ArrayList<CountryItem> phoneArrayList, Context context) {
        this.countryItems = phoneArrayList;
        this.context = context;
    }

    public CountyRecyclerAdapter(ArrayList<CountryItem> countryItems, Context context, OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener) {
        this.countryItems = countryItems;
        this.context = context;
        this.onCountryRecyclerItemClickListener = onCountryRecyclerItemClickListener;
    }

    @NonNull
    @Override
    public CountyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        String name = countryItems.get(position).getName();
        holder.name.setText(name);
        String region = countryItems.get(position).getRegion();
        holder.region.setText(region);
        Log.println(DEBUG, "Errrr", countryItems.get(position).getFlag());

        // Glide.with(holder.flag).load(countryItems.get(position).getFlag()).placeholder(R.drawable.ic_arrow_back).into(holder.flag);
       // holder.flag.loadUrl(countryItems.get(position).getFlag());
        RequestBuilder requestBuilder;
        requestBuilder =
                GlideApp.with(holder.container.getContext())
                        .as(PictureDrawable.class)
                        .transition(withCrossFade())
                        .listener(new SvgSoftwareLayerSetter());
        Uri newUri = Uri.parse(countryItems.get(position).getFlag());
        requestBuilder.load(newUri).into(holder.flag);
        //  holder.flag.setImageURI(Uri.parse(countryItems.get(position).getFlag()));
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCountryRecyclerItemClickListener != null) {
                    onCountryRecyclerItemClickListener.onItemClick(v, holder.getAdapterPosition());
                }
            }
        });
        if (position == countryItems.size() - 1) {
            holder.divider.setVisibility(View.INVISIBLE);
        } else {
            holder.divider.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        if (countryItems != null)
            return countryItems.size();
        else return 0;
    }

    public void setListener(OnCountryRecyclerItemClickListener listener) {
        this.onCountryRecyclerItemClickListener = listener;
    }

    public ArrayList<CountryItem> getCountryItems() {
        return countryItems;
    }

    public void setItems(ArrayList<CountryItem> countryItems) {
        this.countryItems = countryItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView region;
        AppCompatImageView flag;
        View divider;
        View container;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            region = view.findViewById(R.id.region);
            flag = view.findViewById(R.id.flag);
            divider = view.findViewById(R.id.divider);
            container = view;
        }
    }

}
