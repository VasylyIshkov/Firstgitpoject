package com.example.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.CountyRecyclerAdapter;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentChooser extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private ArrayList<CountryItem> countryItems;
    private CountyRecyclerAdapter countyRecyclerAdapter;
    private OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener;

    public FragmentChooser() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chooser, container, false);
        initFragment(view);
        return view;

    }

    public CountyRecyclerAdapter getCountyRecyclerAdapter() {
        return countyRecyclerAdapter;
    }

    public CountryItem getItem(int position) {
        Log.println(Log.DEBUG, "Errr", countryItems.get(1).getInfo() + " get itm");
        return countryItems.get(position);

    }

    public void clearCountryItems() {
        countryItems.clear();
    }

    public void addAll(List<CountryItem> countryItems) {
        try {


            clearCountryItems();
            //  countryItems = new ArrayList<>();
            Log.println(Log.DEBUG, "Errr", countryItems.size() + " count2.0");
            this.countryItems.addAll(countryItems);
            //  countyRecyclerAdapter.notifyDataSetChanged();
            Log.println(Log.DEBUG, "Errr", countryItems.size() + " count2");
            countyRecyclerAdapter = new CountyRecyclerAdapter((ArrayList) this.countryItems, view.getContext(), onCountryRecyclerItemClickListener);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            countyRecyclerAdapter.setListener(onCountryRecyclerItemClickListener);
            recyclerView.setAdapter(countyRecyclerAdapter);
        } catch (Exception ex) {
            Log.println(Log.DEBUG, "Errr", ex.getMessage());
        }

    }

    private void initFragment(final View view) {
        this.view = view;
        countryItems = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view);
        countyRecyclerAdapter = new CountyRecyclerAdapter(countryItems, view.getContext(), onCountryRecyclerItemClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(countyRecyclerAdapter);

    }


    public void setOnCountryRecyclerItemClickListener(OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener) {
        this.onCountryRecyclerItemClickListener = onCountryRecyclerItemClickListener;
        countyRecyclerAdapter.setListener(onCountryRecyclerItemClickListener);
    }


}


