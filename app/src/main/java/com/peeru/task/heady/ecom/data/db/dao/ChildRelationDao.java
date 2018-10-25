package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.peeru.task.heady.ecom.data.db.entity.ChildRelation;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Dao
public interface ChildRelationDao {
    @Query("SELECT * FROM child_relation")
    LiveData<List<ChildRelation>> getAllChildRelation();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertChildRelation(ChildRelation childRelation);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ChildRelation> childRelationList);

    @Update
    void updateChildRelation(ChildRelation childRelation);

    @Delete
    void deleteChildRelation(ChildRelation childRelation);
}
