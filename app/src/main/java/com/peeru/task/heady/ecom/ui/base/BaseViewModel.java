package com.peeru.task.heady.ecom.ui.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.peeru.task.heady.ecom.data.remote.response.Response;

public abstract class BaseViewModel<T> extends ViewModel {

    protected final MutableLiveData<Response<T>> response = new MutableLiveData<>();

    protected final MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>();

    public abstract void loadData();

    public MutableLiveData<Response<T>> getResponse() {
        return response;
    }

    public MutableLiveData<Boolean> getLoadingStatus() {
        return loadingStatus;
    }
}
