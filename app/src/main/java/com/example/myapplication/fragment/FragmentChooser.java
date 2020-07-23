package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
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


    private OnPhoneRecyclerItemClickListener onPhoneRecyclerItemClickListener;
    private RecyclerView recyclerView;
    private ArrayList<Phone> phoneArrayList;
    private PhoneRecyclerAdapter phoneRecyclerAdapter;
    View view;

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
        view = inflater.inflate(R.layout.fragment_chooser, container, false);
        initArrayList();
        initFragment(view);
        return view;

    }
public Phone getPhone(int position){
        return  phoneArrayList.get(position);
}
    private void initFragment(final View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        phoneRecyclerAdapter = new PhoneRecyclerAdapter(phoneArrayList);
        Toast.makeText(view.getContext(),"Chooser",Toast.LENGTH_SHORT).show();
        phoneRecyclerAdapter.setListener(onPhoneRecyclerItemClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(phoneRecyclerAdapter);
    }

    public void setOnTaskRecyclerItemClickListener(OnPhoneRecyclerItemClickListener onTaskRecyclerItemClickListener) {
        this.onPhoneRecyclerItemClickListener = onTaskRecyclerItemClickListener;
    }

    private void initArrayList() {
        phoneArrayList = new ArrayList<>();
        AppCompatImageView imageView = new AppCompatImageView(view.getContext());
        imageView.setImageResource(R.drawable.xiaomi_mi_10);
        Phone xiaomi = new Phone("Xiaomi Mi 10", "Qualcomm Snapdragon 865", "8Gb", imageView);
        phoneArrayList.add(xiaomi);
        imageView.setImageResource(R.drawable.samsun);
        Phone samsung = new Phone("Samsung Galaxy M21", "Samsung Exynos 9611", "4Gb", imageView);
        phoneArrayList.add(samsung);
        imageView.setImageResource(R.drawable.apple_iphone_se);
        Phone iphone = new Phone("iPhone SE 64GB", "Apple A13 Bionic", "3Gb", imageView);
        phoneArrayList.add(iphone);
        imageView.setImageResource(R.drawable.realme_6);
        Phone relame = new Phone("Realme 6 Pro", " Qualcomm Snapdragon 720G", "8Gb", imageView);
        phoneArrayList.add(relame);
        imageView.setImageResource(R.drawable.huawei_p30);
        Phone huawei = new Phone("Huawei P30 Lite", "HiSilicon Kirin 710", "4Gb", imageView);
        phoneArrayList.add(huawei);
    }
}