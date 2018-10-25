package com.peeru.task.heady.ecom.data.db;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.peeru.task.heady.ecom.data.db.dao.CategoriesDao;
import com.peeru.task.heady.ecom.data.db.dao.CategoriesRelationDao;
import com.peeru.task.heady.ecom.data.db.dao.ChildRelationDao;
import com.peeru.task.heady.ecom.data.db.dao.ProductDao;
import com.peeru.task.heady.ecom.data.db.dao.RankingDao;
import com.peeru.task.heady.ecom.data.db.dao.VariantsDao;
import com.peeru.task.heady.ecom.data.db.entity.Categories;
import com.peeru.task.heady.ecom.data.db.entity.ChildRelation;
import com.peeru.task.heady.ecom.data.db.entity.Product;
import com.peeru.task.heady.ecom.data.db.entity.Rankings;
import com.peeru.task.heady.ecom.data.db.entity.Variants;


@android.arch.persistence.room.Database(
        entities = {Categories.class, ChildRelation.class, Product.class, Variants.class, Rankings.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {

        private static AppDatabase INSTANCE;

        public static AppDatabase getDatabase(Context context) {
            if (INSTANCE == null) {
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "ecom_db")
                                .allowMainThreadQueries()
                                .build();
            }
            return INSTANCE;
        }

    public abstract CategoriesDao categoriesDao();
    public abstract CategoriesRelationDao categoriesRelationDao();
    public abstract ChildRelationDao childRelationDao();
    public abstract ProductDao productDao();
    public abstract VariantsDao variantsDao();
    public abstract RankingDao rankingDao();


    public static void destroyInstance() {
        INSTANCE = null;
    }
}