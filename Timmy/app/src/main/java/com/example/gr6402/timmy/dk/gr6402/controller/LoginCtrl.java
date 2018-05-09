package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.gr6402.timmy.R;
import com.example.gr6402.timmy.dk.gr6402.controller.MenuPractitionerCtrl;


public class LoginCtrl extends AppCompatActivity {
    // objekter i viewet defineres her som attributter, med type og id på objektet.
    private Button btnLogin;
    private CheckBox cbCheckClinic;
    private Button btnNewUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        cbCheckClinic = (CheckBox) findViewById(R.id.cbCheckClinic); // forbinder java klassen med objektet i viewet
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnNewUser = (Button) findViewById(R.id.btnNewUser);


        //   final Button btnLogin = (Button) findViewById(R.id.btnLogin);
        //   btnLogin.setOnClickListener(new View.OnClickListener() {


        // }) ;
    }
       // {

    public void handleLogin (View view){
        if (cbCheckClinic.isChecked()) {
            //Toast.makeText(this, "Loui er gud", Toast.LENGTH_SHORT).show();
            MenuPractitionerCtrl menuPractitionerCtrl = new MenuPractitionerCtrl();
            menuPractitionerCtrl.showMenuPractitioner();



           // return btnLogin.get(MenuPractitionerCtrl).showMenuPractitioner();
            }
            else {
                  //  Toast.makeText(this, "Steffen staaaahp", Toast.LENGTH_SHORT).show();
                }
    }




    public void handleCheckClinic(View view){
        //todo skal synliggøre klinik feltet når klikket på
    }


    public void handleNewUser(View view){

    }
}
