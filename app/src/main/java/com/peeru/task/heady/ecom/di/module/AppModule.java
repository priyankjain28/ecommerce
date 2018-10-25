package com.peeru.task.heady.ecom.di.module;

import com.peeru.task.heady.ecom.data.remote.Api;
import com.peeru.task.heady.ecom.domain.repository.ItemRepository;
import com.peeru.task.heady.ecom.util.scheduler.BaseScheduler;
import com.peeru.task.heady.ecom.util.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    @Singleton
    ItemRepository provideUserRepository(Api api) {
        return new ItemRepository(api);
    }

    @Provides
    @Singleton
    BaseScheduler provideSchedulerProvider() {
        return new SchedulerProvider();
    }

}