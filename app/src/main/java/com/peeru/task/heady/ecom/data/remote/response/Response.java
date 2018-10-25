package com.peeru.task.heady.ecom.data.remote.response;

import android.support.annotation.Nullable;

import static com.peeru.task.heady.ecom.data.remote.response.Status.ERROR;
import static com.peeru.task.heady.ecom.data.remote.response.Status.SUCCESS;

public class Response<T> {

    public final int status;

    @Nullable
    public final T data;

    @Nullable
    public final Throwable throwable;

    private Response(int status, @Nullable T data, @Nullable Throwable throwable) {
        this.status = status;
        this.data = data;
        this.throwable = throwable;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(SUCCESS, data, null);
    }

    public static <T> Response<T> error(Throwable error) {
        return new Response<>(ERROR, null, error);
    }

}
