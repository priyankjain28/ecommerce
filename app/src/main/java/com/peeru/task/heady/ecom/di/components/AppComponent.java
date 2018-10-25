package com.peeru.task.heady.ecom.di.components;

import com.peeru.task.heady.ecom.App;
import com.peeru.task.heady.ecom.di.module.ActivityBuildersModule;
import com.peeru.task.heady.ecom.di.module.AppModule;
import com.peeru.task.heady.ecom.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuildersModule.class,
        AppModule.class,
        NetworkModule.class})
interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {}

}