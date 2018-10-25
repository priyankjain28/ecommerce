package com.peeru.task.heady.ecom.util.scheduler;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;


public interface BaseScheduler {

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

}