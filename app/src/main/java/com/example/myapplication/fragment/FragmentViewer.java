package com.example.myapplication.fragment;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import com.example.myapplication.Constants;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.svg.GlideApp;
import com.example.myapplication.svg.SvgSoftwareLayerSetter;

import java.io.InputStream;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class FragmentViewer extends BaseFragment implements ViewerContract.View {
    private AppCompatTextView textView;
    private AppCompatImageView imageView;
    RequestBuilder requestBuilder;
    private ViewerContract.Presenter presenter;

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
        View view = inflater.inflate(R.layout.fragment_viewer, container, false);
        initToolbarWithNavigation(getString(R.string.second_activity_title), view);
        textView = view.findViewById(R.id.choose_info);
        imageView = view.findViewById(R.id.image_view);
        requestBuilder =
                GlideApp.with(this)
                        .as(PictureDrawable.class)
                        .transition(withCrossFade())
                        .listener(new SvgSoftwareLayerSetter());
        try {
            presenter.takeView(this);
            String countryInfo = getActivity().getIntent().getStringExtra(Constants.COUNTRY_INFO);
            String flagUri = getActivity().getIntent().getStringExtra(Constants.FLAG_URI);
            if(!countryInfo.equals(null)) {
                presenter.setData(flagUri, countryInfo);
                showInfo();
            }
        } catch (Exception ex) {
            Log.println(Log.DEBUG, "Errr", ex.getMessage());
        }

        return view;
    }

//    public void displayResorce(CountryItem countryItem) {
//        Uri uri = Uri.parse(countryItem.getFlag());
//        requestBuilder.load(uri).into(imageView);
//        textView.setText(countryItem.getInfo());
//    }

    public void displayResorce(String info, Uri uri) {
        textView.setText(info);
        requestBuilder.load(uri).into(imageView);
    }

    @Override
    public void showInfo() {
        displayResorce(presenter.getInfo(),presenter.getUri());
    }

    @Override
    public void setPresenter(ViewerContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            presenter.dropView();
        } catch (Exception ex) {
            Log.println(Log.DEBUG, "Errr", ex.getMessage());
        }
    }


}