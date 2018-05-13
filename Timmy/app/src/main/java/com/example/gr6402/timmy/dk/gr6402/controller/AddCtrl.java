package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gr6402.timmy.R;

public class AddCtrl extends AppCompatActivity {

    private TextView employmentIDTxt;
    private EditText employmentIDField;
    private TextView employmentIDTxt2;
    private EditText employmentIDField2;
    private TextView cprTxt;
    private EditText cprField;
    private TextView cprTxt2;
    private EditText cprField2;
    private TextView nyhaTxt;
    private Spinner nyhaChoice;
    private Button btnOk;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        employmentIDTxt = (TextView) findViewById(R.id.employmentIDTxt);
        employmentIDField = (EditText) findViewById(R.id.employmentIDField);
        employmentIDTxt2 = (TextView) findViewById(R.id.employmentIDTxt2);
        employmentIDField2 = (EditText) findViewById(R.id.employmentIDField2);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprField = (EditText) findViewById(R.id.cprField);
        cprTxt2 = (TextView) findViewById(R.id.cprTxt2);
        cprField2 = (EditText) findViewById(R.id.cprField2);
        nyhaTxt = (TextView) findViewById(R.id.nyhaTxt);
        nyhaChoice = (Spinner) findViewById(R.id.nyhaChoice);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);


    }

    public void handleOk(View view){

    }

    public void handleCancel(View view){

    }
}
