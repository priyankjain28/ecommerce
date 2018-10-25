package com.peeru.task.heady.ecom;




import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import com.peeru.task.heady.ecom.di.components.DaggerAppComponent;

public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends App> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}