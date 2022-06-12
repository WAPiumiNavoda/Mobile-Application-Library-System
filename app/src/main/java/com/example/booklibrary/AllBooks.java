package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.booklibrary.database.DBHelper;

import java.util.ArrayList;

public class AllBooks extends AppCompatActivity {

    RecyclerView recyclerView;

    DBHelper dbHelper;
    ArrayList<String> book_id, book_name, book_author;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        ArrayList arrayList;
        ArrayAdapter adapter;
        DBHelper db;
        ListView booklist;

        booklist = findViewById(R.id.listbook);

        db = new DBHelper(getApplicationContext());

        arrayList = db.readAllBookList();

        adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1,arrayList);

        booklist.setAdapter(adapter);


    }
}