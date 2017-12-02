package com.example.foodcalorie.model;

/**
 * Created by Wirasinee on 29-Nov-17.
 */

public class FoodItem {
    public final int id;
    public final String title;
    public final String calorie;
    public final String type;
    public final String picture;

    public FoodItem(int id, String title, String calorie, String type, String picture) {
        this.id = id;
        this.title = title;
        this.calorie = calorie;
        this.type = type;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return title;
    }

}
