package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;

public class DeleteDialogCtrl extends AppCompatActivity {

    private TextView cprTxt;
    private TextView cprLabel;
    private TextView employmentIDTxt;
    private TextView employmentIDLabel;
    private TextView firstNameTxt;
    private TextView firstNameLabel;
    private TextView lastNameTxt;
    private TextView lastNameLabel;
    private Button btnOk;
    private Button btnCancel;
    private Bundle bun;
    private int val;
    private Practitioner loginPractitioner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletedialog);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        employmentIDTxt = (TextView) findViewById(R.id.employmentIDTxt);
        employmentIDLabel = (TextView) findViewById(R.id.employmentIDLabel);
        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        firstNameLabel = (TextView) findViewById(R.id.firstNameLabel);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        lastNameLabel = (TextView) findViewById(R.id.lastNameLabel);
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
            cprLabel.setVisibility(View.GONE);
        }
        else if (val == 1) {
            employmentIDTxt.setVisibility(View.GONE);
            employmentIDLabel.setVisibility(View.GONE);
        }
    }

    public void handleOk(View view){
        Intent i = new Intent(this, OverviewCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if (val == 0) {
            //TODO Den valgte læge inkl. data skal slettes fra databasen.
            bundle.putInt("VAL", val); // fra delete practitioner til practitioner overview val=0
        }
        else if (val == 1) {
            //TODO Den valgte patient inkl. data skal slettes fra databasen.
            bundle.putInt("VAL", val); //fra delete patient til patient overview val=1
        }
        i.putExtras(bundle);
        startActivity(i);
    }

    public void handleCancel(View view){
        Intent i = new Intent(this, OverviewCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if (val == 0) {
            bundle.putInt("VAL", val); // fra delete practitioner til practitioner overview val=0
        }
        else if (val == 1) {
            bundle.putInt("VAL", val); //fra delete patient til patient overview val=1
        }
        i.putExtras(bundle);
        startActivity(i);
    }
}
