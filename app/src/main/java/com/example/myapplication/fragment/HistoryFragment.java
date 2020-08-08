package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Constants;
import com.example.myapplication.R;
import com.example.myapplication.adapters.HistoryRecyclerAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.listeners.OnCountryRecyclerItemClickListener;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class HistoryFragment extends BaseFragment implements HistoryContract.View {
    private HistoryContract.Presenter presenter;
    private RecyclerView recyclerView;
    private ArrayList<String> historyList;
    View view;
    private OnCountryRecyclerItemClickListener listener = new OnCountryRecyclerItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent();
            intent.putExtra(Constants.CHOOSE_REQUEST, historyList.get(position));
            getActivity().setResult(RESULT_OK, intent);
            getActivity().finish();
        }
    };
    HistoryRecyclerAdapter adapter;

    public HistoryFragment() {
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
        view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.history_list);
        initToolbarWithNavigation(getString(R.string.history), view);
        try {
            presenter.takeView(this);
            historyList = presenter.getItems();
            adapter = new HistoryRecyclerAdapter(historyList, view.getContext(), listener);
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            recyclerView.setAdapter(adapter);
            adapter.setListener(listener);
            showInfo();
        } catch (Exception ex) {
            Log.println(Log.DEBUG, "Errr", ex.getMessage());
        }

        return view;
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

    @Override
    public void showInfo() {

    }

    @Override
    public void setPresenter(HistoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}