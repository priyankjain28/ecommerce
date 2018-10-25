package com.peeru.task.heady.ecom.di.module;


import com.peeru.task.heady.ecom.ui.item.ListItemsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public interface FragmentBuildersModule {

    @ContributesAndroidInjector
    ListItemsFragment contributeListItemsFragment();

}