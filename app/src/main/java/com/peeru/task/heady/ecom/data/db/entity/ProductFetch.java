package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by Priyank Jain on 24-10-2018.
 */
public class ProductFetch {
    @Embedded
    Product product;

    @Relation(parentColumn = "id", entityColumn = "product_id", entity = Variants.class)
    List<Variants> variantList;

    @Relation(parentColumn = "category_id", entityColumn = "id", entity = Categories.class)
    List<Categories> categories;

    @Relation(parentColumn = "category_id", entityColumn = "id", entity = ChildRelation.class)
    List<ChildRelation> childRelationList;

    @Relation(parentColumn = "id", entityColumn = "id", entity = Rankings.class)
    List<Rankings> rankings;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Variants> getVariantList() {
        return variantList;
    }

    public void setVariantList(List<Variants> variantList) {
        this.variantList = variantList;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public List<ChildRelation> getChildRelationList() {
        return childRelationList;
    }

    public void setChildRelationList(List<ChildRelation> childRelationList) {
        this.childRelationList = childRelationList;
    }

    public List<Rankings> getRankings() {
        return rankings;
    }

    public void setRankings(List<Rankings> rankings) {
        this.rankings = rankings;
    }

    @Override
    public String toString() {
        return "ProductFetch{" +
                "product=" + product +
                ", variantList=" + variantList +
                ", categories=" + categories +
                ", childRelationList=" + childRelationList +
                ", rankings=" + rankings +
                '}';
    }

    public String rankingsChildrelationString() {
        return "ProductFetch{" +
                "product=" + product +
                ", childRelationList=" + childRelationList +
                ", rankings=" + rankings +
                '}';
    }
}
