package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.peeru.task.heady.ecom.data.db.entity.Product;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Dao
public interface ProductDao {

    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAllProduct();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Product> productList);

    @Update
    void updateProduct(Product product);



    @Delete
    void deleteProduct(Product product);
}
