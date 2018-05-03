package com.example.gr6402.timmy;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class LoginLaege extends AppCompatActivity {

    //MaterialBetterSpinner betterSpinner = (MaterialBetterSpinner) findViewById(R.id.TextKlinik);

    RelativeLayout MyLayout;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_laege);

        MyLayout = (RelativeLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) MyLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();
    }

    public void OnClickBox(View view) {

        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }


}
