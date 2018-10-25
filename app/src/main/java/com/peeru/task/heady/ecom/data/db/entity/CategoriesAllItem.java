package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by Priyank Jain on 23-10-2018.
 */
public class CategoriesAllItem {

    @Embedded
    Categories categories;

    @Relation(parentColumn = "id", entityColumn = "category_id", entity = Product.class)
    List<Product> productList;

    @Relation(parentColumn = "id", entityColumn = "category_id", entity = Variants.class)
    List<Variants> variantList;

    @Relation(parentColumn = "id", entityColumn = "category_id", entity = ChildRelation.class)
    List<ChildRelation> childRelationList;


    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Variants> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variants> variantList) {
        this.variantList = variantList;
    }

    public List<ChildRelation> getChildRelationList() {
        return childRelationList;
    }

    public void setChildRelationList(List<ChildRelation> childRelationList) {
        this.childRelationList = childRelationList;
    }

    @Override
    public String toString() {
        return "CategoriesAllItem{" +
                "categories=" + categories +
                ", productList=" + productList +
                ", variantList=" + variantList +
                ", childRelationList=" + childRelationList +
                '}';
    }
}
