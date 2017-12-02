package com.example.foodcalorie;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.foodcalorie.adapter.FoodListAdapter;
import com.example.foodcalorie.db.FoodDbHelper;
import com.example.foodcalorie.model.FoodItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton mSweet_button ;
    ImageButton mFood_button ;
    ImageButton mFruit_button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSweet_button = (ImageButton) findViewById(R.id.sweet_button);
        mFood_button = (ImageButton) findViewById(R.id.food_button);
        mFruit_button = (ImageButton) findViewById(R.id.fruit_button);

        mSweet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Path2.class);//(context.คลาสปลายทางที่จะรัน)
                intent.putExtra("type","1"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });
        mFood_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Path2.class);//(context.คลาสปลายทางที่จะรัน)
                intent.putExtra("type","2"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });

        mFruit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Path2.class);//(context.คลาสปลายทางที่จะรัน)
                intent.putExtra("type","3"); //ส่งค่าไปแอคทิวิตีปลายทาง
                startActivity(intent);
            }
        });
    }
}
