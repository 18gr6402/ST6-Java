package com.example.gr6402.timmy.dk.gr6402.controller;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;

public class OverviewCtrl extends AppCompatActivity {

    private TableLayout overviewTable;
    private TextView userIDColumn;
    private TextView firstNameColumn;
    private TextView lastNameColumn;
    private TextView employmentIDTxt;
    private TextView employmentIDLabel;
    private TextView cprTxt;
    private TextView cprLabel;
    private TextView firstNameTxt;
    private TextView firstNameLabel;
    private TextView lastNameTxt;
    private TextView lastNameLabel;
    private TextView nyhaTxt;
    private TextView nyhaLabel;
    private TextView mpiThresholdTxt;
    private TextView mpiThresholdLabel;
    private TextView mpiTimeChartTxt;
    private GraphView mpiTimeChart;
    private Button btnInspectMonitoring;
    private Button btnAdd;
    private Button btnEdit;
    private Button btnDelete;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview);
       // graph = (GraphView) = findViewById(R.id.graph);

        overviewTable = (TableLayout) findViewById(R.id.overviewTable);
        userIDColumn = (TextView) findViewById(R.id.userIDColumn);
        firstNameColumn = (TextView) findViewById(R.id.firstNameColumn);
        lastNameColumn = (TextView) findViewById(R.id.lastNameColumn);
        employmentIDTxt = (TextView) findViewById(R.id.employmentIDTxt);
        employmentIDLabel = (TextView) findViewById(R.id.employmentIDLabel);
        cprTxt = (TextView) findViewById(R.id.cprTxt);
        cprLabel = (TextView) findViewById(R.id.cprLabel);
        firstNameTxt = (TextView) findViewById(R.id.firstNameTxt);
        firstNameLabel = (TextView) findViewById(R.id.firstNameLabel);
        lastNameTxt = (TextView) findViewById(R.id.lastNameTxt);
        lastNameLabel = (TextView) findViewById(R.id.lastNameLabel);
        nyhaTxt= (TextView) findViewById(R.id.nyhaTxt);
        nyhaLabel = (TextView) findViewById(R.id.nyhaLabel);
        mpiThresholdTxt = (TextView) findViewById(R.id.mpiThresholdTxt);
        mpiThresholdLabel = (TextView) findViewById(R.id.mpiThresholdLabel);
        mpiTimeChartTxt = (TextView) findViewById(R.id.mpiTimeChartTxt);
        mpiTimeChart = (GraphView) findViewById(R.id.mpiTimeChart);
        btnInspectMonitoring = (Button) findViewById(R.id.btnInspectMonitorering);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnBack = (Button) findViewById(R.id.btnBack);
    }


    public void handleInspectMonitoring(View view){

    }

    public void handleAdd(View view){

    }

    public void handleEdit(View view){

    }

    public void handleDelete(View view){

    }

    public void handleBack(View view){

    }

}
