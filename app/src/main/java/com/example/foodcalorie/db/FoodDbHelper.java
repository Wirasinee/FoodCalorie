package com.example.foodcalorie.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wirasinee on 29-Nov-17.
 */

public class FoodDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "food.db";
    private static final int DATABASE_VERSION = 1;

    //ชื่อฟิล
    public static final String TABLE_NAME = "food";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";//ชื่ออาหาร
    public static final String COL_CALORIE= "calorie";//แคลอรีอาหาร
    public static final String COL_TYPE = "type";//ประเภทอาหาร
    public static final String COL_PICTURE = "picture";//รูออาหาร

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_TITLE + " TEXT,"
            + COL_CALORIE + " TEXT,"
            + COL_TYPE + " TEXT,"
            + COL_PICTURE + " TEXT)";

    public FoodDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //ถ้าฐานข้อมูลยังไม่มีก็จะมาทำตรงนี้
        db.execSQL(CREATE_TABLE); //ไปสร้างตาราง
        insertInitialData(db);//ใส่ข้อมูลลงตาราง
    }

    private void insertInitialData(SQLiteDatabase db) {//idไม่ต้องใส่เพราะเดียวandroidทำให้เอง
        //ข้อมูล ขนมหวาน(หมวด1) 1
        ContentValues cv = new ContentValues();
        //putค่าต่างๆใส่ลงcv
        cv.put(COL_TITLE,"กล้วยบวชชี 1 ถ้วย");//ใส่ฟิลไหน,ค่าที่ใส่
        cv.put(COL_CALORIE,"230 Kcal");
        cv.put(COL_TYPE,"1");
        cv.put(COL_PICTURE,"S001.jpg");
        //app->New->Foder->Asset จะได้Fodel asset ไปหารูปมาใส่
        //เอาcv ใส่ลงฐานข้อมูล
        db.insert(TABLE_NAME,null,cv);//ชื่อตาราง,null,cv
        //ข้อมูล2
        cv = new ContentValues();
        cv.put(COL_TITLE,"กุ่ยช่าย(นึ่ง) 1 ชิ้น");
        cv.put(COL_CALORIE,"140 Kcal");
        cv.put(COL_TYPE,"1");
        cv.put(COL_PICTURE,"S002.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล3
        cv = new ContentValues();
        cv.put(COL_TITLE,"ขนมครก 2 คู่");
        cv.put(COL_CALORIE,"210 Kcal");
        cv.put(COL_TYPE,"1");
        cv.put(COL_PICTURE,"S003.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล4
        cv = new ContentValues();
        cv.put(COL_TITLE,"ขนมชั้น 2 ชิ้น");
        cv.put(COL_CALORIE,"184 Kcal");
        cv.put(COL_TYPE,"1");
        cv.put(COL_PICTURE,"S004.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล5
        cv = new ContentValues();
        cv.put(COL_TITLE,"ขนมตาล 2 กระทง");
        cv.put(COL_CALORIE,"115 Kcal");
        cv.put(COL_TYPE,"1");
        cv.put(COL_PICTURE,"S005.jpg");
        db.insert(TABLE_NAME,null,cv);

        //ข้อมูล ผลไม้(หมวด2) 1
        cv = new ContentValues();
        cv.put(COL_TITLE,"กล้วยน้ำว้า 1 ผล");
        cv.put(COL_CALORIE,"60 Kcal");
        cv.put(COL_TYPE,"2");
        cv.put(COL_PICTURE,"Fr001.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล2
        cv = new ContentValues();
        cv.put(COL_TITLE,"กกล้วยหอม 1 ผล");
        cv.put(COL_CALORIE,"120 Kcal");
        cv.put(COL_TYPE,"2");
        cv.put(COL_PICTURE,"Fr002.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล3
        cv = new ContentValues();
        cv.put(COL_TITLE,"ขนุน 2 ยวง");
        cv.put(COL_CALORIE,"60 Kcal");
        cv.put(COL_TYPE,"2");
        cv.put(COL_PICTURE,"Fr003.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล4
        cv = new ContentValues();
        cv.put(COL_TITLE,"ชมพู่ 2-3 ผล");
        cv.put(COL_CALORIE,"60 Kcal");
        cv.put(COL_TYPE,"2");
        cv.put(COL_PICTURE,"Fr004.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล5
        cv = new ContentValues();
        cv.put(COL_TITLE,"ทุเรียน 100 กรัม");
        cv.put(COL_CALORIE,"165 Kcal");
        cv.put(COL_TYPE,"2");
        cv.put(COL_PICTURE,"Fr005.jpg");
        db.insert(TABLE_NAME,null,cv);

        //ข้อมูล อาหาร(หมวด3) 1
        cv = new ContentValues();
        cv.put(COL_TITLE,"ข้าวผัดรวมมิตรทะเล");
        cv.put(COL_CALORIE,"660 Kcal");
        cv.put(COL_TYPE,"3");
        cv.put(COL_PICTURE,"001.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล2
        cv = new ContentValues();
        cv.put(COL_TITLE,"กะเพราะไก่-ไข่ดาว");
        cv.put(COL_CALORIE,"630 Kcal");
        cv.put(COL_TYPE,"3");
        cv.put(COL_PICTURE,"002.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล3
        cv = new ContentValues();
        cv.put(COL_TITLE,"ข้าวมันไก่");
        cv.put(COL_CALORIE,"596 Kcal");
        cv.put(COL_TYPE,"3");
        cv.put(COL_PICTURE,"003.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล4
        cv = new ContentValues();
        cv.put(COL_TITLE,"ข้าวขาหมู");
        cv.put(COL_CALORIE,"690 Kcal");
        cv.put(COL_TYPE,"3");
        cv.put(COL_PICTURE,"004.jpg");
        db.insert(TABLE_NAME,null,cv);
        //ข้อมูล5
        cv = new ContentValues();
        cv.put(COL_TITLE,"ข้าวคลุกกะปิ");
        cv.put(COL_CALORIE,"410 Kcal");
        cv.put(COL_TYPE,"3");
        cv.put(COL_PICTURE,"005.jpg");
        db.insert(TABLE_NAME,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);//ลบตารางออก
        onCreate(db);
        //แล้วไปปรับ เวอชัน
        //หรือลบแอพทิ้งแล้วรันใหม่ก็ได้
    }

}//end class
