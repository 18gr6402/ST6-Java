package com.example.gr6402.timmy.dk.gr6402.controller;

import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gr6402.timmy.R;




public class MenuPractitionerCtrl extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menupractitioner);


    }

    public void showMenuPractitioner(){
        Intent in_menupractitioner = new Intent(this, MenuPractitionerCtrl.class);
        startActivity(in_menupractitioner);
      //  Toast.makeText(this, "Loui er gud", Toast.LENGTH_SHORT).show();

    }
}
