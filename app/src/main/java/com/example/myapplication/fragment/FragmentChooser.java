package com.example.myapplication.fragment;

import android.content.Intent;
import android.graphics.drawable.PictureDrawable;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.RequestBuilder;
import com.example.myapplication.AddPhone;
import com.example.myapplication.Constants;
import com.example.myapplication.R;
import com.example.myapplication.SecondActivity;
import com.example.myapplication.adapters.CountyRecyclerAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.classes.ApplicationRequestManager;
import com.example.myapplication.classes.CountryItem;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;
import com.example.myapplication.svg.GlideApp;
import com.example.myapplication.svg.SvgSoftwareLayerSetter;
import com.example.myapplication.utils.KeyboardUtils;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_CANCELED;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class FragmentChooser extends BaseFragment implements ChooserContract.View {

    private RecyclerView recyclerView;
    private View loader;
    private View view;
    private AppCompatEditText searchQuery;
    private AppCompatButton startSearch;
    private Menu menu;
    private ArrayList<CountryItem> countryItems;
    private CountyRecyclerAdapter countyRecyclerAdapter;
    private AppCompatImageView imageView;
    private AppCompatTextView textView;
    boolean inLandscapeMode;
    RequestBuilder requestBuilder;

    private ChooserContract.Presenter presenter;

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
        String title = getString(R.string.main_activity_title);
        Log.println(Log.DEBUG, "Errr", title);
        initToolbar(title, view);
        searchQuery = view.findViewById(R.id.country_name);
        searchQuery.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_GO) {
                    presenter.searchRepos(searchQuery.getText().toString());
                    clearQuery();
                    return true;
                }
                return false;
            }
        });
        startSearch = view.findViewById(R.id.start_search);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.searchRepos(searchQuery.getText().toString());
                clearQuery();
            }
        });
        menu = getToolbar().getMenu();
        menu.clear();
        menu.add(R.string.history);


        countryItems = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycler_view);

        countyRecyclerAdapter = new CountyRecyclerAdapter(countryItems, view.getContext(), new OnCountryRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showFullInfo(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(countyRecyclerAdapter);
        loader = view.findViewById(R.id.loader);
        this.view = view;
        inLandscapeMode = view.findViewById(R.id.image_view) != null;
        if (inLandscapeMode) {
            imageView = view.findViewById(R.id.image_view);
            textView = view.findViewById(R.id.choose_info);
            requestBuilder =
                    GlideApp.with(this)
                            .as(PictureDrawable.class)
                            .transition(withCrossFade())
                            .listener(new SvgSoftwareLayerSetter());
        }
        try {
            presenter.takeView(this);
        } catch (Exception ex) {
            Log.println(Log.DEBUG, "Errr", ex.getMessage());
        }

        return view;

    }

    private void showFullInfo(int position) {
        if (inLandscapeMode) {
            textView.setText(countryItems.get(position).getInfo());
            Uri newUri = Uri.parse(countryItems.get(position).getFlag());
            requestBuilder.load(newUri).into(imageView);
        } else {
            Intent intent = new Intent(getActivity(), SecondActivity.class);
            intent.putExtra(Constants.COUNTRY_INFO, countryItems.get(position).getInfo());
            intent.putExtra(Constants.FLAG_URI, countryItems.get(position).getFlag());
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        showHistory();
        return true;
    }

    private void showHistory() {
        Intent intent = new Intent(getActivity(), AddPhone.class);
        intent.putExtra(Constants.CHOOSE_REQUEST, presenter.getManager().getArrayPRequest(getContext()));
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            String result = data.getStringExtra(Constants.CHOOSE_REQUEST);
            searchQuery.setText(result);
            presenter.searchRepos(result);
        }
    }

    public CountyRecyclerAdapter getCountyRecyclerAdapter() {
        return countyRecyclerAdapter;
    }

    public CountryItem getItem(int position) {
        //   Log.println(Log.DEBUG, "Errr", countryItems.get(0).getInfo() + " get itm");
        return countryItems.get(position);

    }

    public void clearCountryItems() {
        countryItems.clear();
    }


    public void showProgressBlock() {
        if (loader != null) {
            loader.setVisibility(View.VISIBLE);
        }
    }

    public void hideProgressBlock() {
        if (loader != null) {
            loader.setVisibility(View.GONE);
        }
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

    private void clearQuery() {
        searchQuery.setText(null);
    }

    @Override
    public void showInputError() {
        searchQuery.requestFocus();
    }

    @Override
    public void showRequestError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void observeItems(LiveData<List<CountryItem>> itemsLiveData) {
        itemsLiveData.observe(FragmentChooser.this, new Observer<List<CountryItem>>() {
            @Override
            public void onChanged(List<CountryItem> countryItem) {
                countryItems.clear();
                countryItems.addAll(countryItem);
                countyRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void stopObserving(LiveData<List<CountryItem>> liveRepoData) {
        liveRepoData.removeObservers(FragmentChooser.this);
    }


    @Override
    public void setPresenter(ChooserContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showProgress() {
        showProgressBlock();
    }

    @Override
    public void hideProgress() {
        hideProgressBlock();
    }

    @Override
    public void hideKeyboard() {
        KeyboardUtils.hide(view);
    }
}


