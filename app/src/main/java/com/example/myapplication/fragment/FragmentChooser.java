package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class FragmentChooser extends Fragment {

    private AppCompatButton xiaomiButton, samsungButton, iphoneButton, realmeButton, huaweiButton;

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
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_chooser, container, false);
        View view = inflater.inflate(R.layout.fragment_chooser, container, false);
        xiaomiButton = view.findViewById(R.id.btn_xiaomi);
        samsungButton = view.findViewById(R.id.btn_samsung);
        iphoneButton = view.findViewById(R.id.btn_iphone);
        realmeButton = view.findViewById(R.id.btn_realme);
        huaweiButton = view.findViewById(R.id.btn_huawei);

        return view;

    }
}