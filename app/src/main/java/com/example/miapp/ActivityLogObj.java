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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;


public class ActivityLogObj extends AppCompatActivity{

    private ArrayList<Obj> miObjList;
    private SharedPreferences sharedPref;

    //muestreo de pantallas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_view);

    }
    // mostrar pantalla tipo de vista
    public void setTypeView(View view){
        setContentView(R.layout.activity_type_view);
    }

    //Pantallas de Botones
    //Boton lista desgun prioridad
    public void onViewAllButtonClicked(View Button){ setContentView(R.layout.activity_lis_item2); }

    //Boton vista en total
    public void onSaveNewButtonClicked(View button){
        setContentView(R.layout.activity_objlist);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        //Reboot
        SharedPreferences.Editor delete = sharedPref.edit();
        delete.clear();
        delete.apply();

        //guardar pequenha info
        String objList = sharedPref.getString("miObjetivo", new ArrayList<Obj>().toString());

        Gson gson = new Gson();
        //typoetoken=permite guardar cualquier tipo de info en un array
        TypeToken<ArrayList<Obj>> objArrayList = new TypeToken<ArrayList<Obj>>(){};
        miObjList = gson.fromJson(objList, objArrayList.getType());
        //el Log=permite
        Log.d("miFav", miObjList.toString());

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("miObjetivo", gson.toJson(miObjList));
        editor.apply();

        objListAdapter objlistAdapter = new
    }

}
