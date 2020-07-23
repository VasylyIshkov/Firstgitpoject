package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.PhoneRecyclerAdapter;
import com.example.myapplication.classes.Phone;
import com.example.myapplication.listeners.OnPhoneRecyclerItemClickListener;

import java.util.ArrayList;

public class FragmentChooser extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Phone> phoneArrayList;
    private PhoneRecyclerAdapter phoneRecyclerAdapter;

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
        initArrayList();
        initFragment(view);
        return view;

    }

    public Phone getPhone(int position) {
        return phoneArrayList.get(position);
    }

    private void initFragment(final View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        phoneRecyclerAdapter = new PhoneRecyclerAdapter(phoneArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(phoneRecyclerAdapter);
    }


    public void setOnPhoneRecyclerItemClickListener(OnPhoneRecyclerItemClickListener onPhoneRecyclerItemClickListener) {
        phoneRecyclerAdapter.setListener(onPhoneRecyclerItemClickListener);
    }

    private void initArrayList() {
        phoneArrayList = new ArrayList<>();
        Phone xiaomi = new Phone("Xiaomi Mi 10", "Qualcomm Snapdragon 865", "8Gb", R.drawable.xiaomi_mi_10);
        phoneArrayList.add(xiaomi);
        Phone samsung = new Phone("Samsung Galaxy M21", "Samsung Exynos 9611", "4Gb", R.drawable.samsun);
        phoneArrayList.add(samsung);
        Phone iphone = new Phone("iPhone SE 64GB", "Apple A13 Bionic", "3Gb", R.drawable.apple_iphone_se);
        phoneArrayList.add(iphone);
        Phone relame = new Phone("Realme 6 Pro", " Qualcomm Snapdragon 720G", "8Gb", R.drawable.realme_6);
        phoneArrayList.add(relame);
        Phone huawei = new Phone("Huawei P30 Lite", "HiSilicon Kirin 710", "4Gb", R.drawable.huawei_p30);
        phoneArrayList.add(huawei);
    }
}