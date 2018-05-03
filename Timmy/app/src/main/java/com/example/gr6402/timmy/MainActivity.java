package com.example.gr6402.timmy;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout MyLayout;
    AnimationDrawable animationDrawable;

    EditText UsernameEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText) findViewById(R.id.etUsername);
        PasswordEt = (EditText) findViewById(R.id.etPassword);

        MyLayout = (RelativeLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) MyLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

    }


    public void OnLogin(View view) {

        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        //if (checkMark == true)
        String type = "login";



        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

    }

    public void OnClickBox(View view) {

        Intent in = new Intent(this, LoginLaege.class);
        startActivity(in);

    }

}