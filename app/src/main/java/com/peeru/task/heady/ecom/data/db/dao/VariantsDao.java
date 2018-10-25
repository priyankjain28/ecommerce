package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.peeru.task.heady.ecom.data.db.entity.Variants;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Dao
public interface VariantsDao {
    @Query("SELECT * FROM variants")
    LiveData<List<Variants>> getAllVariants();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVariants(Variants variants);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Variants> variantsList);

    @Update
    void updateVariants(Variants variants);

    @Delete
    void deleteVariants(Variants variants);
}
