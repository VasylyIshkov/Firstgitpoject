package com.example.myapplication.fragment;

import android.os.Bundle;
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
        return countryItems.get(position);
    }

    public void clearCountryItems() {
        countryItems.clear();
    }

    public void addAll(List<CountryItem> countryItems) {
        countryItems.addAll(countryItems);
    }

    private void initFragment(final View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        countyRecyclerAdapter = new CountyRecyclerAdapter(countryItems, view.getContext(), onCountryRecyclerItemClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(countyRecyclerAdapter);

    }


    public void setOnCountryRecyclerItemClickListener(OnCountryRecyclerItemClickListener onCountryRecyclerItemClickListener) {
        countyRecyclerAdapter.setListener(onCountryRecyclerItemClickListener);
    }


}


