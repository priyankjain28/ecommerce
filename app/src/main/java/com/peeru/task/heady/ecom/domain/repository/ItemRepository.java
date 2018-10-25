package com.peeru.task.heady.ecom.domain.repository;

import com.peeru.task.heady.ecom.data.remote.Api;
import com.peeru.task.heady.ecom.domain.model.ResponseBody;

import javax.inject.Inject;

import io.reactivex.Observable;


public class ItemRepository {

    private Api api;

    @Inject
    public ItemRepository(Api api) {
        this.api = api;
    }

    public Observable<ResponseBody> getItems() {
        return api.fetchItems("https://stark-spire-93433.herokuapp.com/json");
    }

}