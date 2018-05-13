package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gr6402.timmy.R;

public class CollectSCGCtrl extends AppCompatActivity {

    private Button btnViewGuide;
    private Button btnMeasure;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collectscg);
        btnViewGuide = (Button) findViewById(R.id.btnViewGuide);
        btnMeasure = (Button) findViewById(R.id.btnMeasure);
        btnBack = (Button) findViewById(R.id.btnBack);
    }

    public void handleViewGuide(View view){

    }

    public void handleMeasure(View view){

    }

    public void handleBack(View view){

    }
}
