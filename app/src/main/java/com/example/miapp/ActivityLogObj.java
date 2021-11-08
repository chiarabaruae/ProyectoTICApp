package com.example.miapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.DatePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class ActivityLogObj extends AppCompatActivity{

    private ArrayList<Obj> myObjList;
    private SharedPreferences sharedPref;

    //muestreo de pantallas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_view);

    }

    public void setTypeView(View view){
        setContentView(R.layout.activity_type_view);
    }

    public void onViewAllButtonClicked(View Button){ setContentView(R.layout.activity_lis_item2); }

    public void onSaveNewButtonClicked(View button){
        setContentView(R.layout.activity_objlist);

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
