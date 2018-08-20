package com.example.ajitg.allpayhere;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ServiceOptionActivity extends AppCompatActivity {


    int serviceNumber;
    FirebaseDatabase database;
    DatabaseReference mRef , mElec , mFood , mCar , mHealth , mDel , mPlumb;
    Toolbar toolbar;
    List<ServiceOptions> recentOptions = new ArrayList<>();
    List<String> elecName , elecWork ,carName , carWork , foodName , foodWork , healthName , healthWork , plumbName , plumbWork , delName , delWork;
    RecyclerView recyclerView;
    List<String> eName = new ArrayList<>();
    String name = "Ajit" , name1 , name2 , name3 , name4 , name5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_option);

        carName = new ArrayList<>();
        carWork = new ArrayList<>();
        elecName = new ArrayList<>();
        elecWork = new ArrayList<>();
        foodName = new ArrayList<>();
        foodWork = new ArrayList<>();
        healthName = new ArrayList<>();
        healthWork = new ArrayList<>();
        plumbName = new ArrayList<>();
        plumbWork = new ArrayList<>();
        delName = new ArrayList<>();
        delWork = new ArrayList<>();

        database = FirebaseDatabase.getInstance();

        mRef = database.getReference();
        mElec = mRef.child("Electricians");
        mCar = mRef.child("Carpenter");
        mDel = mRef.child("Delivery");
        mHealth = mRef.child("Doctors");
        mFood = mRef.child("Fooder");
        mPlumb = mRef.child("Plumber");

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        Intent newIntent = getIntent();
        serviceNumber = newIntent.getIntExtra("id" , 0);
        getSupportActionBar().setTitle(newIntent.getStringExtra("title"));

        recyclerView = findViewById(R.id.recyclerView);

        switch (serviceNumber){

            case 1:
                mElec.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            elecName.add((String) ds.child("name").getValue());
                            elecWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < elecName.size() ; i++){

                            recentOptions.add(new ServiceOptions(elecName.get(i), elecWork.get(i) , "Electrician" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);

                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            case 2:
                mPlumb.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            plumbName.add((String) ds.child("name").getValue());
                            plumbWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < plumbName.size() ; i++){

                            recentOptions.add(new ServiceOptions(plumbName.get(i), plumbWork.get(i) , "Plumber" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);
                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            case 3:
                mHealth.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            healthName.add((String) ds.child("name").getValue());
                            healthWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < healthName.size() ; i++){

                            recentOptions.add(new ServiceOptions(healthName.get(i), healthWork.get(i) , "Doctor" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);

                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            case 4:
                mFood.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            foodName.add((String) ds.child("name").getValue());
                            foodWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < foodName.size() ; i++){

                            recentOptions.add(new ServiceOptions(foodName.get(i), foodWork.get(i) , "Fooder" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);
                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            case 5:
                mDel.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            delName.add((String) ds.child("name").getValue());
                            delWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < delName.size() ; i++){

                            recentOptions.add(new ServiceOptions(delName.get(i), delWork.get(i) , "Delivery" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);

                    }



                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            case 6:
                mCar.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot ds : dataSnapshot.getChildren()) {

                            carName.add((String) ds.child("name").getValue());
                            carWork.add((String) ds.child("workId").getValue());

                        }
                        for(int i = 0 ; i < carName.size() ; i++){

                            recentOptions.add(new ServiceOptions(carName.get(i), carWork.get(i) , "Carpenter" , R.drawable.user));


                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceOptionActivity.this));
                        recyclerView.setHasFixedSize(true);

                        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(ServiceOptionActivity.this , recentOptions);
                        recyclerView.setAdapter(adapter);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                break;

            default :
                return;

        }

























/*
        recentOptions.add(new ServiceOptions(name, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name2, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name3, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name4, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name5, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name1, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions(name5, "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions("Rohit Khanna", "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions("Rohit Khanna", "EN-23456" , "Electrician" , R.drawable.user));
        recentOptions.add(new ServiceOptions("Rohit Khanna", "EN-23456" , "Electrician" , R.drawable.user));




        ServiceOptionRecyclerAdapter adapter = new ServiceOptionRecyclerAdapter(this , recentOptions);
        recyclerView.setAdapter(adapter);

*/
    }
}
