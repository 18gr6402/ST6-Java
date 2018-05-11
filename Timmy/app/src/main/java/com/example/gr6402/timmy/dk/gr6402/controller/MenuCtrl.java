package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class MenuCtrl extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        try {
         Patient loginUser = getIntent().getParcelableExtra("PatientTag");
         System.out.println(loginUser.getCPR());
        }
        catch (Exception e){
            System.out.println("ERROR DAMMIT");

        }


    }



}
