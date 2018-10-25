package com.peeru.task.heady.ecom.data.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.peeru.task.heady.ecom.data.db.entity.Rankings;

import java.util.List;

/**
 * Created by Priyank Jain on 24-10-2018.
 */
@Dao
public interface  RankingDao {
    @Query("SELECT * FROM rankings")
    LiveData<List<Rankings>> getAllRankings();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRankings(Rankings rankings);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Rankings> rankingsList);


    @Update
    void updateRankings(Rankings rankings);

    @Delete
    void deleteRankings(Rankings rankings);
}
