package com.peeru.task.heady.ecom.ui.item;

import com.peeru.task.heady.ecom.data.remote.response.Response;
import com.peeru.task.heady.ecom.domain.model.ResponseBody;
import com.peeru.task.heady.ecom.domain.repository.ItemRepository;
import com.peeru.task.heady.ecom.ui.base.BaseViewModel;
import com.peeru.task.heady.ecom.util.scheduler.BaseScheduler;

import javax.inject.Inject;


public class ListItemViewModel extends BaseViewModel<ResponseBody> {

    private ItemRepository itemRepository;
    private BaseScheduler scheduler;

    @Inject
    public ListItemViewModel(ItemRepository itemRepository, BaseScheduler scheduler) {
        this.itemRepository = itemRepository;
        this.scheduler = scheduler;

    }

    @Override
    public void loadData() {
        itemRepository.getItems()
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .doOnSubscribe(s -> loadingStatus.setValue(true))
                .doAfterTerminate(() -> loadingStatus.setValue(false))
                .subscribe(
                        itemsResponse -> response.setValue(Response.success(itemsResponse)),
                        throwable -> response.setValue(Response.error(throwable))
                );
    }

}
