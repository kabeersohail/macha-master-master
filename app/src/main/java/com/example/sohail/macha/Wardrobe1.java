package com.example.sohail.macha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;



public class Wardrobe1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ListView JavaListView;
    List<Dress> dressList;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe1);

        drawerLayout = findViewById(R.id.drawermacchak);
        navigationView = findViewById(R.id.navigation_viewk);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        JavaListView  = findViewById(R.id.XmlListView);

        dressList = new ArrayList<>();

        dressList.add(new Dress(R.drawable.m1,"₹499","Pants","Fitting"));
        dressList.add(new Dress(R.drawable.m2,"₹499","Pants","Casual"));
        dressList.add(new Dress(R.drawable.m3,"₹499","Pants","Formal"));
        dressList.add(new Dress(R.drawable.m4,"₹499","Pants","Casual"));
        dressList.add(new Dress(R.drawable.m5,"₹499","Pants","Formal"));
        dressList.add(new Dress(R.drawable.w1,"₹499","Pants","Wedding"));
        dressList.add(new Dress(R.drawable.w2,"₹499","Pants","Christmas"));
        dressList.add(new Dress(R.drawable.w3,"₹499","Pants","Diwali"));
        dressList.add(new Dress(R.drawable.w4,"₹499","Pants","Marriage"));
        dressList.add(new Dress(R.drawable.w5,"₹499","Pants","Wedding"));


        DressAdapter adapter = new DressAdapter(this,R.layout.dress_list,dressList);
        JavaListView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.signoutdrawar){
            AuthUI.getInstance().signOut(this);
            startActivity(new Intent(this,MainActivity.class));
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
