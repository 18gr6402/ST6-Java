package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.gr6402.timmy.R;

public class LoginCtrl extends AppCompatActivity {

    private CheckBox checkClinic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        checkClinic=(CheckBox) findViewById(R.id.checkClinic); // forbinder java klassen med objektet i viewet
    }

    public void handleLogin(View view){
        if (checkClinic.isChecked()){
            System.out.println("checkbox er vinget af");
        }

    }

    public void handleCheckClinic(View view){

    }
}
