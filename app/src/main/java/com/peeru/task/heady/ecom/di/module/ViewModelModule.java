package com.peeru.task.heady.ecom.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.peeru.task.heady.ecom.di.keys.ViewModelKey;
import com.peeru.task.heady.ecom.ui.common.ViewModelFactory;
import com.peeru.task.heady.ecom.ui.item.ListItemViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListItemViewModel.class)
    ViewModel bindListItemViewModel(ListItemViewModel listItemViewModel);



    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}