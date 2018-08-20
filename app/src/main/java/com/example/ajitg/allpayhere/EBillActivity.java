package com.example.ajitg.allpayhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.Random;


public class EBillActivity extends AppCompatActivity {

    Toolbar toolbar;
    String personName;
    TextView personNameTextViewBill , distanceTextviewBill , rateRSTextViewBill;
    AppCompatEditText servicesRequiredBill , whereToServiceBill , personAddressEditTextBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebill);


        Intent intent = getIntent();
        personName = intent.getStringExtra("person_name");
        String toolbarHeader = intent.getStringExtra("person_Id");


        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarHeader);

        personNameTextViewBill = findViewById(R.id.personNameTextViewBill);
        personNameTextViewBill.setText(personName);
        distanceTextviewBill = findViewById(R.id.distanceTextviewBill);

        Random rand = new Random();
        Double distance = rand.nextDouble() * 10;
        String result = String.format("%.2f", distance);

        distanceTextviewBill.setText(result + " miles away");

        rateRSTextViewBill = findViewById(R.id.rateRSTextViewBill);


        personAddressEditTextBill = findViewById(R.id.personAddressEditTextBill);
        servicesRequiredBill = findViewById(R.id.servicesRequiredBill);
        whereToServiceBill = findViewById(R.id.whereToServiceBill);


    }
}
