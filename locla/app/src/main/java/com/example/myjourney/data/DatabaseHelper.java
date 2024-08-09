package com.example.myjourney.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "journey.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_PRODUCT = "product";

    // Category Table Columns
    public static final String COLUMN_CATEGORY_ID = "id";
    public static final String COLUMN_CATEGORY_NAME = "name";

    // Product Table Columns
    public static final String COLUMN_PRODUCT_ID = "id";
    public static final String COLUMN_PRODUCT_NAME = "name";
    public static final String COLUMN_PRODUCT_CATEGORY_ID = "categoryId";

    // Create Category Table SQL
    private static final String CREATE_CATEGORY_TABLE =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CATEGORY_NAME + " TEXT NOT NULL);";

    // Create Product Table SQL
    private static final String CREATE_PRODUCT_TABLE =
            "CREATE TABLE " + TABLE_PRODUCT + " (" +
                    COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT_NAME + " TEXT NOT NULL, " +
                    COLUMN_PRODUCT_CATEGORY_ID + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_PRODUCT_CATEGORY_ID + ") REFERENCES " + TABLE_CATEGORY + "(" + COLUMN_CATEGORY_ID + "));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CATEGORY_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        onCreate(db);
    }

    public static String getTableCategory() {
        return TABLE_CATEGORY;
    }

    public static String getColumnCategoryId() {
        return COLUMN_CATEGORY_ID;
    }
    public static String getColumnCategoryName() {
        return COLUMN_CATEGORY_NAME;
    }

    public static String getColumnProductId() {
        return COLUMN_PRODUCT_ID;
    }

    public static String getColumnProductName() {
        return COLUMN_PRODUCT_NAME;
    }

    public static String getColumnProductCategoryId() {
        return COLUMN_PRODUCT_CATEGORY_ID;
    }
}
