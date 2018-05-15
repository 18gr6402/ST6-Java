package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.Practitioner;
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
    private Bundle bun;
    private int val;
    private Practitioner loginPractitioner;
    private Patient selectedPatient;

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

        // hvor kommer vi fra; practitioner warningsmenuen (val = 1) eller practitioner menuCtrl (val = 0)
        bun = getIntent().getExtras();
        val = bun.getInt("VAL");
        loginPractitioner = (Practitioner) getIntent().getParcelableExtra("PractitionerTag");
        selectedPatient = (Patient) getIntent().getParcelableExtra("SelectedPatientTag");
        }

    public void handleBack  (View view){
        Intent i;
        Bundle bundle = new Bundle();
        if (val == 1) {
            i = new Intent(this, WarningsCtrl.class);
            i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
            startActivity(i);
        }
        else if (val==0){
            i = new Intent(this, OverviewCtrl.class);
            i.putExtra("PractitionerTag", (Parcelable) loginPractitioner);
            bundle.putInt("VAL", 1);
            i.putExtras(bundle);
            startActivity(i);
        }
    }
}