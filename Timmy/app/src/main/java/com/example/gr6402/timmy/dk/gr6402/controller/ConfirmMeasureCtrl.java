package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gr6402.timmy.R;

public class ConfirmMeasureCtrl extends AppCompatActivity {

    private TextView confirmTxt;
    private Button btnConfirm;
    private Button btnRetake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmmeasure);
        confirmTxt = (TextView) findViewById(R.id.confirmTxt);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnRetake = (Button) findViewById(R.id.btnRetake);
    }

    public void handleConfirm(View view){

    }

    public void handleRetake(View view){

    }
}
