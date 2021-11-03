package com.example.miapp;

import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;

public class InformationActivity extends MainActivity {
    private String tag = "AcercaDeMiApp";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        Log.d(tag, "Inicia metodo en InformationActivity.OonCreate");
        //int n = Integer.parseInt("n");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    return true;
    }
}
