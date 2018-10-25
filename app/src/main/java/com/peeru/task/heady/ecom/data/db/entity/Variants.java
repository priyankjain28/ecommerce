package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Priyank Jain on 23-10-2018.
 */

@Entity(tableName = "variants")
public class Variants {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "category_id")
    private int categoriesId;
    @ColumnInfo(name = "product_id")
    private int productId;
    @ColumnInfo(name = "color")
    private String color;
    @ColumnInfo(name = "size")
    private String size;
    @ColumnInfo(name = "price")
    private String price;

    public Variants(int id, int categoriesId,int productId, String color, String size, String price) {
        this.id = id;
        this.categoriesId = categoriesId;
        this.productId = productId;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Variants{" +
                "id=" + id +
                ", categoriesId=" + categoriesId +
                ", productId=" + productId +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
