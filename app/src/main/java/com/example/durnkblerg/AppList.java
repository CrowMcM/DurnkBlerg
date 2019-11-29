package com.example.durnkblerg;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class AppList extends AppCompatActivity {

    private static String name;
    static Drawable icon;
    static int locked;
    String package_name;

    public AppList(String name,Drawable icon,int locked,String package_name){
        this.name=name;
        this.icon=icon;
        this.locked=locked;
        this.package_name=package_name;
    }

public static String getName(){
        return name;
}
    public void setName(String name) {
        this.name = name;
    }

    public static Drawable getIcon() {
        return icon;
    }
    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
    public static int getLocked(){return locked;}
    public String getPackage_name(){return package_name;}

    public void setPackage_name(String package_name){this.package_name=package_name;}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_app_list );
    }
}
