package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
@Entity(tableName = "child_relation")
public class ChildRelation {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    public ChildRelation(int id, int categoryId) {
        this.id = id;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ChildRelation{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                '}';
    }
}
