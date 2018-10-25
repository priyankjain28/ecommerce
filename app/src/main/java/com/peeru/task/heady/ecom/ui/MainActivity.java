package com.peeru.task.heady.ecom.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.peeru.task.heady.ecom.R;
import com.peeru.task.heady.ecom.databinding.ActivityMainBinding;
import com.peeru.task.heady.ecom.ui.item.ListItemsFragment;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    private ActivityMainBinding binding;
    private ListItemsFragment listItemsFragment = new ListItemsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();
    }

    private void setupViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_item, listItemsFragment)
                .addToBackStack(null)
                .commit();

    }


}
