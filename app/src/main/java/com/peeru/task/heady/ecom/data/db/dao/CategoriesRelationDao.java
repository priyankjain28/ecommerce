package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.peeru.task.heady.ecom.data.db.entity.CategoriesAllItem;
import com.peeru.task.heady.ecom.data.db.entity.ProductFetch;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Dao
public interface CategoriesRelationDao {
    @Transaction
    @Query("SELECT * FROM categories WHERE id = :id")
    LiveData<CategoriesAllItem> loadDataWithId(Integer id);

    @Transaction
    @Query("SELECT * FROM categories")
    LiveData<List<CategoriesAllItem>> loadData();

    @Transaction
    @Query("SELECT * FROM product")
    LiveData<List<ProductFetch>> loadDataProduct();
}
