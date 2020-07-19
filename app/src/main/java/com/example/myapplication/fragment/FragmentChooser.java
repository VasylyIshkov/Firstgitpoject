package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.listeners.FragmentChooseListener;

public class FragmentChooser extends Fragment {

    private AppCompatButton xiaomiButton, samsungButton, iphoneButton, realmeButton, huaweiButton;
    private FragmentChooseListener fragmentChooseListener;

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

    private void initFragment(View view) {
        xiaomiButton = view.findViewById(R.id.btn_xiaomi);
        samsungButton = view.findViewById(R.id.btn_samsung);
        iphoneButton = view.findViewById(R.id.btn_iphone);
        realmeButton = view.findViewById(R.id.btn_realme);
        huaweiButton = view.findViewById(R.id.btn_huawei);
        xiaomiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentChooseListener != null) {
                    fragmentChooseListener.onXiaomiClick();
                }
            }
        });
        samsungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentChooseListener != null) {
                    fragmentChooseListener.onSamsungClick();
                }
            }
        });
        iphoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentChooseListener != null) {
                    fragmentChooseListener.onIphoneClick();
                }
            }
        });
        realmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentChooseListener != null) {
                    fragmentChooseListener.onRelameClick();
                }
            }
        });
        huaweiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentChooseListener != null) {
                    fragmentChooseListener.onHuaweiClick();
                }
            }
        });
    }

    public void setFragmentChooseListener(FragmentChooseListener fragmentChooseListener) {
        this.fragmentChooseListener = fragmentChooseListener;
    }
}