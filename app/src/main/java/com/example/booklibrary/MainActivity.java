package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booklibrary.database.DBHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText bookname, bookauthor;
    Button addbook,allbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookname = findViewById(R.id.bookname);
        bookauthor = findViewById(R.id.bookauthor);
        addbook = findViewById(R.id.addbook);
        allbook = findViewById(R.id.allbook);





        allbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooks.class);
                startActivity(intent);}
        });


        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);

                String editbook = bookname.getText().toString();
                String editauthor = bookauthor.getText().toString();

                if(editbook.isEmpty() || editauthor.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Values", Toast.LENGTH_LONG).show();
                }else{
                    long inserted = dbHelper.addbook(editbook,editauthor);

                    if(inserted>0){
                        Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Somthing went Wrrong", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }


}