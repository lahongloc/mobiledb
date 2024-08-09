package com.example.myjourney.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myjourney.data.DatabaseHelper;
import android.database.Cursor;

public class CategoryDAO {
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public CategoryDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public long insertCategory(String name) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CATEGORY_NAME, name);
        return database.insert(DatabaseHelper.TABLE_CATEGORY, null, values);
    }

    public Cursor getAllCategories() {
        String[] columns = {
                DatabaseHelper.getColumnCategoryId(),
                DatabaseHelper.getColumnCategoryName()
        };
        return database.query(DatabaseHelper.getTableCategory(), columns, null, null, null, null, null);
    }

    public void close() {
        dbHelper.close();
    }
    // Implement other CRUD operations as needed...
}
