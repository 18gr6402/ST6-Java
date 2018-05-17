package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.model.Clinic;
import com.example.gr6402.timmy.dk.gr6402.model.Patient;
import com.example.gr6402.timmy.dk.gr6402.model.SCGMeasure;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseOperations;
import com.example.gr6402.timmy.dk.gr6402.myinterface.DatabaseTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SymptomsCtrl extends AppCompatActivity implements DatabaseOperations, AdapterView.OnItemSelectedListener{

    private TextView anginaTxt;
    private Spinner anginaChoice;
    private TextView dyspneaTxt;
    private Spinner dyspneaChoice;
    private TextView fatigueTxt;
    private Spinner fatigueChoice;
    private TextView weightTxt;
    private EditText weightField;
    private TextView otherTxt;
    private EditText otherField;
    private Button btnOk;
    private Patient loginPatient;
    private SCGMeasure newSCG;
    private Clinic ptClinic = new Clinic(0,null,null);
    private Boolean loadDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms);
        anginaTxt = (TextView) findViewById(R.id.anginaTxt);
        anginaChoice = (Spinner) findViewById(R.id.anginaChoice);
        ArrayAdapter<CharSequence> anginaAdapter = ArrayAdapter.createFromResource(this, R.array.Angina, android.R.layout.simple_spinner_item); //Laver en adapter ud fra de forudbestemte lister i strings.xml
        anginaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //tror det bare er stilen på dropdownen
        anginaChoice.setAdapter(anginaAdapter);
        anginaChoice.setOnItemSelectedListener(this);

        dyspneaTxt = (TextView) findViewById(R.id.dyspneaTxt);
        dyspneaChoice = (Spinner) findViewById(R.id.dyspneaChoice);
        ArrayAdapter<CharSequence> dyspneaAdapter = ArrayAdapter.createFromResource(this, R.array.Dyspnea, android.R.layout.simple_spinner_item);
        dyspneaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dyspneaChoice.setAdapter(dyspneaAdapter);
        dyspneaChoice.setOnItemSelectedListener(this);


        fatigueTxt = (TextView) findViewById(R.id.fatigueTxt);
        fatigueChoice = (Spinner) findViewById(R.id.fatigueChoice);
        ArrayAdapter<CharSequence> fatigueAdapter = ArrayAdapter.createFromResource(this, R.array.Fatigue, android.R.layout.simple_spinner_item);
        fatigueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fatigueChoice.setAdapter(fatigueAdapter);
        fatigueChoice.setOnItemSelectedListener(this);

        weightTxt = (TextView) findViewById(R.id.weightTxt);
        weightField = (EditText) findViewById(R.id.weightField);
        otherTxt = (TextView) findViewById(R.id.otherTxt);
        otherField = (EditText) findViewById(R.id.otherField);
        btnOk = (Button) findViewById(R.id.btnOk);

        //get intent, henter pakkerne der sendes fra MeasureCtrl
        loginPatient = (Patient) getIntent().getParcelableExtra("PatientTag");
        newSCG = (SCGMeasure) getIntent().getParcelableExtra("newSCGTag");

        // load af de gamle symptomer fra databasen
        String type = "loadSYMP";
        String id = loginPatient.getCpr().toString();
        DatabaseTask databaseTask = new DatabaseTask(this);
        databaseTask.execute(type,id);
    }


    /*
    Holder øje med om noget bliver valgt i de tre dropdowns.
    Sætter symptomerne i newSCG efter hvad vælges.
     */
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        /* Use the following switch-statement if you want to keep all spinner actions/callbacks together */
        /* The same can be done to the onNothingSelected callback */
        switch(parent.getId()) {
            case R.id.anginaChoice:
                // Do stuff for anginaChoice
                newSCG.setAngina(pos);
                showToast("In switch-statement for anginaChoice. Value=" + parent.getItemAtPosition(pos));
                break;
            case R.id.dyspneaChoice:
                // Do stuff for dyspneaChoice
                newSCG.setDyspnea(pos);
                showToast("In switch-statement for dyspneaChoice. Value=" + parent.getItemAtPosition(pos));
                break;
            case R.id.fatigueChoice:
                // Do stuff for fatigueChoice
                newSCG.setFatigue(pos);
                showToast("In switch-statement for fatigueChoice. Value=" + parent.getItemAtPosition(pos));
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // hvad der skal ske hvis der ikke vælges nogen.
    }


    /*
    ("utility")Metode for visning af toast's
     */
    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    /*
    Køres i onTaskCompleted efter load af data
    Viser de hentede data i view'et.
    */
    public void showDetails(String[] seperated){
        //læser de sepererede strings ind i passende instancer til brug i resten af klassen
        int id = Integer.parseInt(seperated[0]);
        ptClinic.setClinicID(id);
        newSCG.setAngina(Integer.parseInt(seperated[1]));
        newSCG.setDyspnea(Integer.parseInt(seperated[2]));
        newSCG.setFatigue(Integer.parseInt(seperated[3]));
        newSCG.setWeight(Integer.parseInt(seperated[4]));
        //ændre view så dropdowns viser de gamle symptomer ud fra de hentede int fra databasen gemt i den nye måling
        anginaChoice.setSelection(newSCG.getAngina());
        dyspneaChoice.setSelection(newSCG.getDyspnea());
        fatigueChoice.setSelection(newSCG.getFatigue());

        weightField.setText(newSCG.getWeight().toString());
    }


    /*
    Køres ved tryk på OK knap i view.
    Læser vægt og andre, setter dem i newSCG.
    Køre en DatabaseTask og gemmer dermed dataen i databsen.
    Catch og viser fejl hvis ej.
     */
    public void handleOk(View view){
        newSCG.setWeight(Integer.parseInt(weightField.getText().toString()));
        newSCG.setOther(otherField.getText().toString());
        //Gem de indberettede symptomer med dags dato i databasen.
        String type = "saveSCG"; //TODO lav saveSCG i DatabaseTask
        String clinicID = ptClinic.getClinicID().toString();
        String cpr = loginPatient.getCpr().toString();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());;
        String weight = newSCG.getWeight().toString();
        String angina = newSCG.getAngina().toString();
        String dyspnea = newSCG.getDyspnea().toString();
        String fatigue = newSCG.getFatigue().toString();
        String other = newSCG.getOther();
        String scgZ = newSCG.getScg();
        try {
            DatabaseTask databaseTask = new DatabaseTask(this);
            databaseTask.execute(type, clinicID, cpr, date, weight, angina, dyspnea, fatigue, other, scgZ);
        } catch (Exception e) {
            showToast("Fejl i gem af data");
            //TODO Hvis det indberettede data ikke indsendes korrekt skal der komme en fejlmeddelelse og du skal føres tilbage til symptomindberetningen igen.
        }
    }


    /*
    Køres hvis en DatabaseTask lykkedes.
    Giver forskellige udfald aghængig af om det er loadSymp eller saveSCG der er blevet kørt.
     */
    @Override
    public void onTaskCompleted(String output) {
        String[] separated = output.split(",");
        if (loadDone == false) {
            showDetails(separated);
            loadDone = true;
        } else {
            Intent i = new Intent(this, MainMenuCtrl.class);
            i.putExtra("PatientTag", (Parcelable) loginPatient);
            startActivity(i);
        }
    }
}
