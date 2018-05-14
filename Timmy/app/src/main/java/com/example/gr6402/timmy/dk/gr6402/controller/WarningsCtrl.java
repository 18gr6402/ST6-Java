package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.jjoe64.graphview.GraphView;

import org.w3c.dom.Text;

public class WarningsCtrl extends AppCompatActivity {

    private TableLayout warningTable;
    private TextView dateColumn;
    private TextView cprColumn;
    private TextView cprTxt;
    private TextView cprLabel;
    private TextView firstNameTxt;
    private TextView firstNameLabel;
    private TextView lastNameTxt;
    private TextView lastNameLabel;
    private TextView nyhaTxt;
    private TextView nyhaLabel;
    private TextView symptomsWarningTxt;
    private TextView symptomsWarningLabel;
    private TextView mpiWarningTxt;
    private TextView mpiWarningLabel;
    private GraphView symptomTimeChart;
    private GraphView mpiTimeChart;
    private Button btnBack;
    private Button btnInspectMonitoring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warnings);
        warningTable = (TableLayout) findViewById(R.id.warningTable);
        dateColumn = (TextView) findViewById(R.id.dateColumn);
        cprColumn = (TextView) findViewById(R.id.cprColumn);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        firstNameLabel = (TextView) findViewById(R.id.firstNameLabel);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        lastNameLabel = (TextView) findViewById(R.id.lastNameLabel);
        nyhaTxt = (TextView) findViewById(R.id.nyhaTxt);
        nyhaLabel = (TextView) findViewById(R.id.nyhaLabel);
        symptomsWarningTxt = (TextView) findViewById(R.id.symptomsWarningTxt);
        symptomsWarningLabel = (TextView) findViewById(R.id.symptomsWarningLabel);
        mpiWarningTxt = (TextView) findViewById(R.id.mpiWarningTxt);
        mpiWarningLabel = (TextView) findViewById(R.id.mpiWarningLabel);
        symptomTimeChart = (GraphView) findViewById(R.id.symptomTimeChart);
        mpiTimeChart = (GraphView) findViewById(R.id.mpiTimeChart);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnInspectMonitoring = (Button) findViewById(R.id.btnInspectMonitoring);
    }

    public void handleBack (View view){

    }

    public void handleInspectMonitoring (View view) {

    }
}
