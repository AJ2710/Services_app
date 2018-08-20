package com.example.ajitg.allpayhere;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigation;
    ImageView electricityImageView , plumberImageView , healthImageView , foodImageView , deliveryImageView , carpenterImageView;


    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){

            drawerLayout.closeDrawer(GravityCompat.START);

        }else{

            super.onBackPressed();

        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Services");

        electricityImageView = findViewById(R.id.electricityImageView);
        plumberImageView = findViewById(R.id.plumberImageView);
        healthImageView = findViewById(R.id.healthImageView);
        foodImageView = findViewById(R.id.foodImageView);
        deliveryImageView = findViewById(R.id.deliveryImageView);
        carpenterImageView = findViewById(R.id.carpenterImageView);

        electricityImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent elecIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                elecIntent.putExtra("title" , "Electricians");
                elecIntent.putExtra("id" , 1);
                startActivity(elecIntent);

            }
        });

        plumberImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent plumbIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                plumbIntent.putExtra("title" , "Plumbers");
                plumbIntent.putExtra("id" , 2);
                startActivity(plumbIntent);


            }
        });

        healthImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent healthIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                healthIntent.putExtra("title" , "Doctors");
                healthIntent.putExtra("id" , 3);
                startActivity(healthIntent);


            }
        });

        foodImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent foodIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                foodIntent.putExtra("title" , "Food Suppliers");
                foodIntent.putExtra("id" , 4);
                startActivity(foodIntent);

            }
        });

        deliveryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent deliveryIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                deliveryIntent.putExtra("title" , "Delivery Mans");
                deliveryIntent.putExtra("id" , 5);
                startActivity(deliveryIntent);


            }
        });

        carpenterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent carpenterIntent = new Intent(MainActivity.this , ServiceOptionActivity.class);
                carpenterIntent.putExtra("title" , "Carpenters");
                carpenterIntent.putExtra("id" , 6);
                startActivity(carpenterIntent);


            }
        });

        drawerLayout = findViewById(R.id.drawerLayout);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {

                    case R.id.myAccountDrawer:
                        Toast.makeText(MainActivity.this, "My account", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.myOrdersDrawer:
                        Toast.makeText(MainActivity.this, "My orders", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.helpFeedbackDrawer:
                        Toast.makeText(MainActivity.this, "Help and feedback", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.settingsDrawer:
                        Toast.makeText(MainActivity.this, "Setings", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.signOutDrawer:
                        Toast.makeText(MainActivity.this, "Log out", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }

                return true;

            }
        });

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id){

                    case R.id.bottomNavHome:
                        Toast.makeText(MainActivity.this , "Home" , Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.bottomNavPay:
                        Toast.makeText(MainActivity.this , "Pay" , Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.bottomNavSetting:
                        Toast.makeText(MainActivity.this , "Settings" , Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout ,toolbar , R.string.open_drawer , R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }

}