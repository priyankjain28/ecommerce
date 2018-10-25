package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.peeru.task.heady.ecom.data.db.entity.Categories;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Dao
public interface CategoriesDao {
    @Query("SELECT * FROM categories")
    LiveData<List<Categories>> getAllCategories();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCategory(Categories categories);

    @Query("SELECT * FROM categories WHERE id = :id")
    LiveData<Categories> getCategory(Integer id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Categories> categoriesList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Categories... categories);

    @Update
    void updateCompany(Categories categories);

    @Update
    void updateCompanies(Categories... categories);

    @Delete
    void deleteCompany(Categories categories);

    @Delete
    void deleteCompanies(Categories... categories);
}
