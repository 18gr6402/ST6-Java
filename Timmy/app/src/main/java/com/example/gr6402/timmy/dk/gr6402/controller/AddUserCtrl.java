package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class AddUserCtrl extends AppCompatActivity {

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
    private Bundle bun;
    private int val;
    private Practitioner loginPractitioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser);
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

        // hvor kommer vi fra; practitioner overviewet (val = 0) eller patienten overviewet (val = 1)
        bun = getIntent().getExtras();
        val = bun.getInt("VAL");
        //get intent
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");

        // Ændre hvilke tekstfelter der er synlige i viewet afhængig af om du kommer fra læge eller patient overviewet.
        if (val == 0) {
            cprTxt.setVisibility(View.GONE);
            cprField.setVisibility(View.GONE);
            cprTxt2.setVisibility(View.GONE);
            cprField2.setVisibility(View.GONE);
            nyhaTxt.setVisibility(View.GONE);
            nyhaChoice.setVisibility(View.GONE);
        }
        else if (val == 1) {
            employmentIDTxt.setVisibility(View.GONE);
            employmentIDField.setVisibility(View.GONE);
            employmentIDTxt2.setVisibility(View.GONE);
            employmentIDField2.setVisibility(View.GONE);
        }
    }

    public void handleOk(View view){
        Intent i = new Intent(this, OverviewCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if (val == 0) {
            //TODO Den tilføjede læge skal gemmes i databasen
            bundle.putInt("VAL", val); // fra add practitioner til practitioner overview val=0
        }
        else if (val == 1) {
            //TODO Den tilføjede patient skal gemmes i databasen
            bundle.putInt("VAL", val); //fra add patient til patient overview val=1
        }
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleCancel(View view){
        Intent i = new Intent(this, OverviewCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if (val == 0) {
            bundle.putInt("VAL", val); // fra add practitioner til practitioner overview val=0
        }
        else if (val == 1) {
            bundle.putInt("VAL", val); //fra add patient til patient overview val=1
        }
        i.putExtras(bundle);
        startActivity(i);
    }
}