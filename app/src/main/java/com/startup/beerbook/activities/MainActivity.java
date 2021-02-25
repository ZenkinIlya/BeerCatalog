package com.startup.beerbook.activities;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.startup.beerbook.R;
import com.startup.beerbook.adapters.BeerAdapter;
import com.startup.beerbook.databinding.ActivityMainBinding;
import com.startup.beerbook.presenters.BeerListPresenter;
import com.startup.beerbook.views.BeerListView;
import com.startup.domain.models.Beer;

import java.util.ArrayList;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements BeerListView {

    private BeerAdapter adapter;
    private ActivityMainBinding binding;

    @InjectPresenter
    BeerListPresenter beerListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupAdapter();

        beerListPresenter.getBeerList();
    }

    private void setupAdapter() {
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BeerAdapter();
        binding.mainRecyclerView.setAdapter(adapter);
    }

    @Override
    public void presentBeers(ArrayList<Beer> beerArrayList) {
        binding.mainRecyclerView.setVisibility(View.VISIBLE);
        binding.mainLoading.setVisibility(View.GONE);
        adapter.setData(beerArrayList);
    }

    @Override
    public void presentLoading() {
        binding.mainRecyclerView.setVisibility(View.GONE);
        binding.mainLoading.setVisibility(View.VISIBLE);
    }
}