package com.example.myjourney;

import android.os.Bundle;
import android.database.Cursor;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myjourney.dao.CategoryDAO;
import com.example.myjourney.data.DatabaseHelper;

public class MainActivity2 extends AppCompatActivity {

    private CategoryDAO categoryDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        categoryDAO = new CategoryDAO(this);

        // Insert a new category
        long newCategoryId = categoryDAO.insertCategory("Electronics");

        // Display all categories
        displayCategories();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void displayCategories() {
        Cursor cursor = categoryDAO.getAllCategories();
        StringBuilder builder = new StringBuilder();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.getColumnCategoryId()));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.getColumnCategoryName()));
            builder.append("ID: ").append(id).append(", Name: ").append(name).append("\n");
        }

        cursor.close();

//        TextView textView = findViewById(R.id.);
//        textView.setText(builder.toString());
    }
}