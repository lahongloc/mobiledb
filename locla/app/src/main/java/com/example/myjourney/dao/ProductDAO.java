package com.example.myjourney.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myjourney.data.DatabaseHelper;

public class ProductDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public ProductDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertProduct(String name, int categoryId) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_PRODUCT_NAME, name);
        values.put(DatabaseHelper.COLUMN_PRODUCT_CATEGORY_ID, categoryId);
        return database.insert(DatabaseHelper.TABLE_PRODUCT, null, values);
    }

    // Implement other CRUD operations as needed...
}

