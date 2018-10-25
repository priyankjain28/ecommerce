package com.peeru.task.heady.ecom.ui.item;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peeru.task.heady.ecom.BuildConfig;
import com.peeru.task.heady.ecom.R;
import com.peeru.task.heady.ecom.data.db.entity.DatabaseInitializer;
import com.peeru.task.heady.ecom.data.remote.response.Status;
import com.peeru.task.heady.ecom.databinding.FragmentListItemsBinding;
import com.peeru.task.heady.ecom.ui.adapter.ItemAdapter;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class ListItemsFragment extends DaggerFragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private FragmentListItemsBinding binding;
    private DatabaseInitializer databaseInitializer;

    private ListItemViewModel viewModel;

    private ItemAdapter itemAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListItemViewModel.class);
        itemAdapter = new ItemAdapter(ListItemsFragment.this);
        databaseInitializer = new DatabaseInitializer(getContext());
        observeLoadingStatus();
        viewModel.loadData();
        observeResponse();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_items, container, false);
        binding.swipeContainer.setOnRefreshListener(viewModel::loadData);
        binding.recyclerView.setAdapter(itemAdapter);
        fetchRecord();
        return binding.getRoot();
    }

    private void fetchRecord() {
        databaseInitializer.loadProductData().observe(this, listOfItem -> {
           itemAdapter.setTaskList(listOfItem);
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void observeLoadingStatus() {
        viewModel.getLoadingStatus().observe(
                this,
                isLoading -> binding.swipeContainer.setRefreshing(isLoading == null ? false : isLoading)
        );
    }

    public void observeResponse() {

        viewModel.getResponse().observe(this, response -> {
            if (response != null && response.status == Status.SUCCESS) {
                databaseInitializer.storeDataToDB(response.data);
                binding.executePendingBindings();
            } else {
                if ((response != null && response.status == Status.ERROR) && BuildConfig.DEBUG) {
                    Log.e("get Item error", String.valueOf(response.throwable));
                }
                Snackbar.make(binding.getRoot(), "Load Data Error", Snackbar.LENGTH_LONG).show();
            }
        });
    }


}