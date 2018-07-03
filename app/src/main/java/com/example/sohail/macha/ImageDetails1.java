package com.example.sohail.macha;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sohail.macha.Adapter.CustomViewPagerAdapter;
import com.example.sohail.macha.Model.Model;
import com.hold1.pagertabsindicator.PagerTabsIndicator;

import java.util.ArrayList;
import java.util.List;

public class ImageDetails1 extends AppCompatActivity {
    int position;
    ViewPager viewPager;
    PagerTabsIndicator pagerTabsIndicator;
    List<Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details1);
        Intent i = getIntent();
        position = i.getExtras().getInt("position");
        initModel();
        viewPager = findViewById(R.id.ViewPager);
        pagerTabsIndicator = findViewById(R.id.tabsIndicator);
        viewPager.setAdapter(new CustomViewPagerAdapter(models,this));
        pagerTabsIndicator.setViewPager(viewPager);
    }

    private void initModel() {
//        for(int i=0;i<4;i++){
//            models.add(new Model("Page "+(i+1),0));
//        }
        Model model;

        if(position == 0){
            model = new Model("Page 1",R.drawable.tshirt0);
            models.add(model);
            model = new Model("Page 2",R.drawable.tshirt1);
            models.add(model);
            model = new Model("Page 3",R.drawable.tshirt2);
            models.add(model);
        }
        else if (position == 1){
            model = new Model("Page 1",R.drawable.sandle1);
            models.add(model);
            model = new Model("Page 2",R.drawable.sandle2);
            models.add(model);
            model = new Model("Page 3",R.drawable.sandle3);
            models.add(model);
            model = new Model("Page 4",R.drawable.sandle4);
            models.add(model);
        }
    }
}
