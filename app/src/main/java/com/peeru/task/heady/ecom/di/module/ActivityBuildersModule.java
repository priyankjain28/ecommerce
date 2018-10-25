package com.peeru.task.heady.ecom.di.module;

import com.peeru.task.heady.ecom.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public interface ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    MainActivity contributeMainActivity();

}
