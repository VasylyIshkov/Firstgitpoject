package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.classes.CountryItem;


public class FragmentViewer extends Fragment {
    private AppCompatTextView textView;
    private WebView imageView;

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
        View view = inflater.inflate(R.layout.fragment_viewer, container, false);
        textView = view.findViewById(R.id.choose_info);
        imageView = view.findViewById(R.id.image_view);
        return view;
    }

    public void displayResorce(CountryItem countryItem) {
       imageView.loadUrl(countryItem.getFlag());
       // Glide.with(imageView).load(countryItem.getFlag()).placeholder(R.drawable.ic_arrow_back).into(imageView);
        textView.setText(countryItem.getInfo());
    }

    public void displayResorce(String info, String uri) {
        imageView.loadUrl(uri);
     //   Glide.with(imageView).load(uri).placeholder(R.drawable.ic_arrow_back).into(imageView);
        textView.setText(info);
    }
}