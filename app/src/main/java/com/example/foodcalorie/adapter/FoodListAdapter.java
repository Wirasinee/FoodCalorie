package com.example.foodcalorie.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodcalorie.R;
import com.example.foodcalorie.model.FoodItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Wirasinee on 29-Nov-17.
 */

public class FoodListAdapter extends ArrayAdapter<FoodItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<FoodItem> mPhoneItemList;

    public FoodListAdapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<FoodItem> phoneItenList) {//layoutResIdือlayoutที่จะให้ใช้
        super(context, layoutResId, phoneItenList);

        this.mContext=context;
        this.mLayoutResId=layoutResId;
        this.mPhoneItemList=phoneItenList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId,null);//แปลงแทคxmlเป็นobj

        FoodItem item = mPhoneItemList.get(position);//ดึงมาจากแหล้งข้อมูล
        //ตอนนี้เราก็จะได้ มาitem 1 แล้ว
        ImageView phoneImageView = itemLayout.findViewById(R.id.food_image_view);//เข้าถึงวิวต่างๆที่อยู่ใน itemLayout
        TextView phoneTitleTextView = itemLayout.findViewById(R.id.food_title_text_view);
        TextView phoneNumberTextView = itemLayout.findViewById(R.id.food_text_view);

        //เอาแต่ละฟิวของไอเทมยัดลง
        phoneTitleTextView.setText(item.title);
        phoneNumberTextView.setText(item.calorie);

//รูป เนื่องจากมันอยู่ในasset ฉะนั้นต้องโหลดมา (ทำแบบR.ดอเวเบิลไม่ได้)
        String pictureFileName=item.picture;
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName); //เปิดไฟล์โดยใช้AssetManager
            Drawable drawable=Drawable.createFromStream(stream,null);//แปลงInputStreamเป็น Drawable
            //สามารถเอาไปsetให้กับรูปภาพได้แล้ว
            phoneImageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemLayout;
        //อแดปเตอของเราก็จะทำงานกับเลเอาที่เราออกแบบเองได้แล้ว
        //ไปที่mainActivity

    }
}
