package com.example.myapplication.fragment;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.caverock.androidsvg.SVG;
import com.example.myapplication.R;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.svg.GlideApp;
import com.example.myapplication.svg.SvgSoftwareLayerSetter;

import java.io.InputStream;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class FragmentViewer extends Fragment {
    private AppCompatTextView textView;
   // private WebView imageView;
    private AppCompatImageView imageView;
    RequestBuilder requestBuilder;

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
        requestBuilder =
                GlideApp.with(this)
                        .as(PictureDrawable.class)
                        .transition(withCrossFade())
                        .listener(new SvgSoftwareLayerSetter());
        return view;
    }

    public void displayResorce(CountryItem countryItem) {
        Uri uri = Uri.parse(countryItem.getFlag());
        requestBuilder.load(uri).into(imageView);
      //  imageView.loadUrl(countryItem.getFlag());
        // Glide.with(imageView).load(countryItem.getFlag()).placeholder(R.drawable.ic_arrow_back).into(imageView);
        textView.setText(countryItem.getInfo());
    }

    public void displayResorce(String info, String uri) {
       // imageView.loadUrl(uri);
        //   Glide.with(imageView).load(uri).placeholder(R.drawable.ic_arrow_back).into(imageView);
        textView.setText(info);
        Uri newUri = Uri.parse(uri);
        requestBuilder.load(newUri).into(imageView);
    }
}