package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gr6402.timmy.R;

import org.w3c.dom.Text;

public class ResetThresholdDialogCtrl extends AppCompatActivity {

    private TextView symptomsLowerThresholdTxt;
    private TextView symptomsLowerThresholdLabel;
    private TextView symptomsUpperThresholdTxt;
    private TextView symptomsUpperThresholdLabel;
    private TextView mpiLowerThresholdTxt;
    private TextView mpiLowerThresholdLabel;
    private TextView mpiUpperThresholdTxt;
    private TextView mpiUpperThresholdLabel;
    private Button btnReset;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetthresholddialog);
        symptomsLowerThresholdTxt = (TextView) findViewById(R.id.symptomsLowerThresholdTxt);
        symptomsLowerThresholdLabel = (TextView) findViewById(R.id.symptomsLowerThresholdLabel);
        symptomsUpperThresholdTxt = (TextView) findViewById(R.id.symptomsUpperThresholdTxt);
        symptomsUpperThresholdLabel = (TextView) findViewById(R.id.symptomsUpperThresholdLabel);
        mpiLowerThresholdTxt = (TextView) findViewById(R.id.mpiLowerThresholdTxt);
        mpiLowerThresholdLabel = (TextView) findViewById(R.id.mpiLowerThresholdLabel);
        mpiUpperThresholdTxt = (TextView) findViewById(R.id.mpiUpperThresholdTxt);
        mpiUpperThresholdLabel = (TextView) findViewById(R.id.mpiUpperThresholdLabel);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnCancel = (Button) findViewById(R.id.btnCancel);
    }

    public void handleReset(View view){

    }

    public void handleCancel(View view){

    }
}
