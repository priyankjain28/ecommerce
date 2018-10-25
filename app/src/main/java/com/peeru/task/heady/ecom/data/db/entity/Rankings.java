package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Priyank Jain on 24-10-2018.
 */
@Entity(tableName = "rankings")
public class Rankings {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "most_viewed")
    private Integer mostViewed = 0;

    @ColumnInfo(name = "most_ordered")
    private Integer mostOrdered = 0;

    @ColumnInfo(name = "most_shared")
    private Integer mostShared = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMostViewed() {
        return mostViewed;
    }

    public void setMostViewed(Integer mostViewed) {
        this.mostViewed = mostViewed;
    }

    public Integer getMostOrdered() {
        return mostOrdered;
    }

    public void setMostOrdered(Integer mostOrdered) {
        this.mostOrdered = mostOrdered;
    }

    public Integer getMostShared() {
        return mostShared;
    }

    public void setMostShared(int mostShared) {
        this.mostShared = mostShared;
    }

    @Override
    public String toString() {
        return "Rankings{" +
                "id=" + id +
                ", mostViewed=" + mostViewed +
                ", mostOrdered=" + mostOrdered +
                ", mostShared=" + mostShared +
                '}';
    }
}
