package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
import com.jjoe64.graphview.GraphView;

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
    private Bundle bun;
    private int val;
    private Practitioner loginPractitioner;
    private Practitioner selectedPractitioner;
    private Patient selectedPatient;

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

        // hvor kommer vi fra: menu:lægekartotek (val = 0) eller menu:patientkatotek/Edit (val = 1)
        bun=getIntent().getExtras();
        val=bun.getInt("VAL");
        //get intent
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");

        showDetails();
    }


    public void showDetails(){
        if(val == 1) {
            employmentIDTxt.setVisibility(View.GONE);
            employmentIDLabel.setVisibility(View.GONE);
            // todo hent og build af data for patienterne i systemet under loginPractitioners clinincID
            // todo input i tabel

        }else if(val == 0){
            cprTxt.setVisibility(View.GONE);
            cprLabel.setVisibility(View.GONE);
            nyhaTxt.setVisibility(View.GONE);
            nyhaLabel.setVisibility(View.GONE);
            mpiThresholdTxt.setVisibility(View.GONE);
            mpiThresholdLabel.setVisibility(View.GONE);
            mpiTimeChartTxt.setVisibility(View.GONE);
            mpiTimeChart.setVisibility(View.GONE);
            btnEdit.setVisibility(View.GONE);
            btnInspectMonitoring.setVisibility(View.GONE);
            btnAdd.setText("Tilføj læge");
            userIDColumn.setText("ID:");
            // todo hent og build af data for læger i systemet under loginPractitioners clinincID
            // todo input i tabel
        }
    }


    public void handleInspectMonitoring(View view){
        Intent i = new Intent(this, InspectMonitoringCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        i.putExtra("selectedPatientTag", selectedPatient);
        startActivity(i);
    }


    public void handleAdd(View view){
        Intent i = new Intent(this, AddUserCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if(val == 1) {
            bundle.putInt("VAL", val);    // Patientkartotek til add -> val = 1
        }else if(val == 0){
            bundle.putInt("VAL", val);    // lægekartotek til add -> val = 0
        }
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleEdit(View view){
        Intent i = new Intent(this, EditUserCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        i.putExtra("selectedPatientTag", selectedPatient);
        Bundle bundle = new Bundle();
        bundle.putInt("VAL", 0);
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleDelete(View view){
        Intent i = new Intent(this, DeleteDialogCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        Bundle bundle = new Bundle();
        if(val == 1) {
            i.putExtra("SelectedPatientTag", (Parcelable) selectedPatient);
            bundle.putInt("VAL", val);    // Patientkartotek til delete -> val = 1
        }else if(val == 0){
            i.putExtra("SelectedPractitionerTag", (Parcelable) selectedPractitioner);
            bundle.putInt("VAL", val);    // lægekartotek til delete -> val = 0
        }
        i.putExtras(bundle);
        startActivity(i);
    }


    public void handleBack(View view){
        Intent i = new Intent(this, MainMenuCtrl.class);
        i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
        startActivity(i);
    }

}
