package com.example.myapplication.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.classes.Phone;


public class FragmentViewer extends Fragment {
private AppCompatTextView textView;
private AppCompatImageView imageView;
    public FragmentViewer() {
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
        View view= inflater.inflate(R.layout.fragment_viewer, container, false);
        textView = view.findViewById(R.id.choose_info);
        imageView = view.findViewById(R.id.image_view);
        return view;
    }
    public void displayResorce(Phone phone){
        Resources res = phone.getImageView().getResources();
        imageView.setImageResource(res.hashCode());
        textView.setText(phone.getInfo());
    }
}