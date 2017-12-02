package com.example.foodcalorie;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.foodcalorie.adapter.FoodListAdapter;
import com.example.foodcalorie.db.FoodDbHelper;
import com.example.foodcalorie.model.FoodItem;

import java.util.ArrayList;

public class Path2 extends AppCompatActivity {

    private FoodDbHelper mHelper;//เข้าถึงdb
    private SQLiteDatabase mDb;//ตัวอ้างอิงdb
    private ArrayList<FoodItem> mFoodItemsList = new ArrayList<>();
    private FoodListAdapter mAdapter;
    String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path2);
        Intent intent = getIntent();
        mType = intent.getStringExtra("type");
        mHelper = new FoodDbHelper(this);
        mDb = mHelper.getReadableDatabase();
        loadDataFromDb();//จะคิวรีข้อมูล ทุกแถว ทุกคอลัม
        mAdapter = new FoodListAdapter(
                this,
                R.layout.item,//<4>layout->new->layout reso->จะได้item.xml  <5>สร้างแพคเกจ adapter -> สร้างPhoneListAdapter.class
                mFoodItemsList
        );
//อ้างอิงถึงลิสวิว
        ListView iv = findViewById(R.id.list_View);
        iv.setAdapter(mAdapter);
//<7> ผู้ใช้/ดแล้วให้โทรออก
        /*
        iv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {//position บอกว่าผู้ใช้กดไอเทมไหน 0ก็คือไอเทมแรก
                FoodItem item = mFoodItemsList.get(position);
                //จะโทรออก ฉะนั้นก็เอาเบอร์โทรออกมา
                String phoneNumber=item.number;

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        });*/

    }//end onCreate

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                //CTRT+P เอาแบบ3
                FoodDbHelper.TABLE_NAME,
                null,//เอามาทุกคอลัม
                FoodDbHelper.COL_TYPE+"="+mType,//"category=1"  คิวรีเแพาะที่มีค่าแคททากอรีเป็น1เท่ารั้ร
                 null,
                null,
                null,
                null
        );

        mFoodItemsList.clear();//เคลียข้อมูลเก่าทิ้ง เผือไว้กรณีผู้ใช้แอดข้อมูลเพิ่มมา
//วนลูปเอาข้อมูลออกมา
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(FoodDbHelper.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_TITLE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle
            String calorie = cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_CALORIE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle
            String type = cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_TYPE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle
            String picture = cursor.getString(cursor.getColumnIndex(FoodDbHelper.COL_PICTURE));  //getมาแต่ละคอลัมของแถวนั้นๆ หรือcursor.getString(1); ช่อง1ตือtitle

            //สร้างโมเดลobj โดยผ่านคอนสตักจอPhoneItem ที่สร้างไว้
            FoodItem item = new FoodItem(id, title, calorie, type, picture);
            mFoodItemsList.add(item);//ข้อมูลขากdbมาอยู่ในนี้หมดแล้ว
        }
    }
}
