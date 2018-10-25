package com.peeru.task.heady.ecom.data.remote;

import com.peeru.task.heady.ecom.domain.model.ResponseBody;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    @GET()
    Observable<ResponseBody> fetchItems(@Url String url);
}