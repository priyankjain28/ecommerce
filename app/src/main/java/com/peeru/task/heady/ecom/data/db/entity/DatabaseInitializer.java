package com.peeru.task.heady.ecom.data.db.entity;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.peeru.task.heady.ecom.data.db.AppDatabase;
import com.peeru.task.heady.ecom.domain.model.Category;
import com.peeru.task.heady.ecom.domain.model.ProductModel;
import com.peeru.task.heady.ecom.domain.model.Product_;
import com.peeru.task.heady.ecom.domain.model.Ranking;
import com.peeru.task.heady.ecom.domain.model.ResponseBody;
import com.peeru.task.heady.ecom.domain.model.Variant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Priyank Jain on 25-10-2018.
 */
public class DatabaseInitializer {
    HashMap<Integer, Rankings> rankingsList = new HashMap<Integer, Rankings>();
    private AppDatabase appDatabase;

    public DatabaseInitializer(Context context) {
        appDatabase = AppDatabase.getDatabase(context);
    }

    public void storeDataToDB(ResponseBody data) {
        for (Category c : data.getCategories()) {
            appDatabase.categoriesDao().insertCategory(new Categories(c.getId(), c.getName()));
            if (!c.getProducts().isEmpty()) {
                for (ProductModel p : c.getProducts()) {
                    appDatabase.productDao().insertProduct(new Product(p.getId(), c.getId(), p.getName(), p.getDateAdded(), p.getTax().getName(), p.getTax().getValue().toString()));
                    if (p.getVariants() != null) {
                        for (Variant v : p.getVariants()) {
                            appDatabase.variantsDao().insertVariants(new Variants(v.getId(), c.getId(), p.getId(), v.getColor(), v.getSize(), v.getPrice().toString()));
                        }
                    }
                }
            }
            if (!c.getChildCategories().isEmpty()) {
                for (Integer cId : c.getChildCategories()) {
                    appDatabase.childRelationDao().insertChildRelation(new ChildRelation(c.getId(), cId));
                }
            }
        }

        for (Ranking r : data.getRankings()) {
            setDataOnMap(r.getProducts(), r.getRanking());
        }
    }

    private void setDataOnMap(List<Product_> products, String type) {
        //rankingsList = new HashMap<Integer, Rankings>();
        for (Product_ p : products) {
            if (!rankingsList.containsKey(p.getId())) {
                Rankings r = new Rankings();
                r.setId(p.getId());
                switch (type) {
                    case "Most Viewed Products":
                        r.setMostViewed(p.getViewCount());
                        break;
                    case "Most OrdeRed Products":
                        r.setMostOrdered(p.getOrderCount());
                        break;
                    case "Most ShaRed Products":
                        r.setMostShared(p.getShares());
                        break;
                }
                rankingsList.put(p.getId(), r);

            } else {
                switch (type) {
                    case "Most Viewed Products":
                        rankingsList.get(p.getId()).setMostViewed(p.getViewCount());
                        break;
                    case "Most OrdeRed Products":
                        rankingsList.get(p.getId()).setMostOrdered(p.getOrderCount());
                        break;
                    case "Most ShaRed Products":
                        rankingsList.get(p.getId()).setMostShared(p.getShares());
                        break;
                }
            }
        }
        List<Rankings> rankings = new ArrayList<>(rankingsList.values());

        appDatabase.rankingDao().insertAll(rankings);

    }

    public LiveData<List<ProductFetch>> loadProductData() {
        return appDatabase.categoriesRelationDao().loadDataProduct();
    }
}
