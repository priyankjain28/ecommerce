package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Priyank Jain on 23-10-2018.
 */

@Entity(tableName = "product")
public class Product {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "category_id")
    private int categoryId;

    @ColumnInfo(name = "product_name")
    private String name;

    @ColumnInfo(name = "date_added")
    private String date_added;

    @ColumnInfo(name = "tax_name")
    private String taxName;

    @ColumnInfo(name = "tax_value")
    private String taxValue;



    public Product(int id, int categoryId, String name, String date_added, String taxName, String taxValue) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.date_added = date_added;
        this.taxName = taxName;
        this.taxValue = taxValue;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(String taxValue) {
        this.taxValue = taxValue;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", date_added='" + date_added + '\'' +
                ", taxName='" + taxName + '\'' +
                ", taxValue='" + taxValue + '\'' +
                '}';
    }
}
