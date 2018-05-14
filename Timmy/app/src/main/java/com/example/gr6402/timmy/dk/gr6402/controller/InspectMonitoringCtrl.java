package com.example.gr6402.timmy.dk.gr6402.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.jjoe64.graphview.GraphView;

public class InspectMonitoringCtrl extends AppCompatActivity {

    private TableLayout scgTable;
    private TextView dateColumn;
    private TextView symptomsColumn;
    private GraphView scgChart;
    private TextView cprTxt;
    private TextView cprLabel;
    private TextView mpiTxt;
    private TextView mpiLabel;
    private TextView symptomsTxt;
    private TextView symptomsLabel;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspectmonitoring);
        scgTable = (TableLayout) findViewById(R.id.scgTable);
        dateColumn = (TextView) findViewById(R.id.dateColumn);
        symptomsColumn = (TextView) findViewById(R.id.symptomsColumn);
        scgChart = (GraphView) findViewById(R.id.scgChart);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        mpiTxt = (TextView) findViewById(R.id.mpiTxt);
        mpiLabel = (TextView) findViewById(R.id.mpiLabel);
        symptomsTxt = (TextView) findViewById(R.id.symptomsTxt);
        symptomsLabel = (TextView) findViewById(R.id.symptomsLabel);
        btnBack = (Button) findViewById(R.id.btnBack);
    }

    public void handleBack  (View view){

    }
}
