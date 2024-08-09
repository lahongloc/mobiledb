package com.example.myjourney;

import android.os.Bundle;

import com.example.myjourney.dao.CategoryDAO;
import com.example.myjourney.data.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myjourney.databinding.ActivityMainBinding;
import android.database.Cursor;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CategoryDAO categoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        categoryDAO = new CategoryDAO(this);
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

        TextView textView = findViewById(R.id.textView3);
        textView.setText(builder.toString());
    }


}