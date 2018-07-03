package com.example.sohail.macha;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.zip.Inflater;

public class Wardrobe extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener{
    GridView gridView;
    ImageView imageView;
    LayoutInflater layoutInflater;
    Context context;
    Button JavaGoogleSignout;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();



        if(id == R.id.signoutdrawar)
        {
            finish();
            AuthUI.getInstance().signOut(this);
            startActivity(new Intent(Wardrobe.this,MainActivity.class));

        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);
        gridView = findViewById(R.id.Xmlgridview);
        gridView.setAdapter(new ImageAdapter(this));
        JavaGoogleSignout = findViewById(R.id.XmlGoogleSignOut1);
        JavaGoogleSignout.setOnClickListener(this);
        navigationView =  findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Wardrobe.this,"You clicked on"+position,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Wardrobe.this,Image.class));
            }
        });
    }



    @Override
    public void onBackPressed() {
        imageView.setVisibility(View.GONE);
        closeContextMenu();
        super.onBackPressed();
    }



    @Override
    public void onClick(View v) {
        if(v == JavaGoogleSignout)
        {
            AuthUI.getInstance().signOut(this);
            startActivity(new Intent(Wardrobe.this,MainActivity.class));
//            JavaGoogleSignout.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
         menuInflater.inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }

        switch (item.getItemId()){


            case R.id.clothes : Toast.makeText(Wardrobe.this,"Clothes",Toast.LENGTH_SHORT).show();
                                return true;

            case R.id.women : Toast.makeText(Wardrobe.this,"Women",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.men : Toast.makeText(Wardrobe.this,"Men",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.kids : Toast.makeText(Wardrobe.this,"Kids",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.boys : Toast.makeText(Wardrobe.this,"Boys",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.girls : Toast.makeText(Wardrobe.this,"Girls",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
