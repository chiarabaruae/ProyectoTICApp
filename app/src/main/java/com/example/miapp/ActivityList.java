package com.example.miapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


import java.util.ArrayList;

public class ActivityList extends AppCompatActivity{
    private ArrayList<Obj> myObjList;
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_obj);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        //        borrar preferencias al reiniciar la app
        SharedPreferences.Editor delete = sharedPref.edit();
        delete.clear();
        delete.apply();

        String objList = sharedPref.getString("MiObj", new ArrayList<Obj>().toString());
        Log.d("Obj String", objList);

        Obj gson = new Obj();

    }
}
