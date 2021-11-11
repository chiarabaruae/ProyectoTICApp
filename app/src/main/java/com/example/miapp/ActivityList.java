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
import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;


import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity implements View.OnClickListener {

    //declaracion de variables
    private EditText nuevoTituloTexto;
    private EditText nuevaDescripTexto;
    private Button botonGuardar;
    private CheckBox completeBox;
    private Button botonElegirFecha;
    private EditText dateTexto;
    private int anho, mes, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_obj);

        nuevoTituloTexto = (EditText) findViewById(R.id.new_task_title);
        nuevaDescripTexto = (EditText) findViewById(R.id.new_task_description);
        botonGuardar = (Button) findViewById(R.id.save_button);
        completeBox = (CheckBox) findViewById(R.id.completeBox);

        botonElegirFecha = (Button) findViewById(R.id.date_button);
        dateTexto = (EditText) findViewById(R.id.due_date);

        botonElegirFecha.setOnClickListener(this);
    }

    //Recopilar informacion
    @Override
    public void onClick(View button) {
        if (button == botonElegirFecha){
            final Calendar calendario = Calendar.getInstance();
            anho = calendario.get(Calendar.YEAR);
            mes = calendario.get(Calendar.MONTH);
            dia = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialogoDeDate = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateTexto.setText(dayOfMonth + "-" + (monthOfYear + 1 )+ "-" + year);
                }
            }, anho, mes, dia);
            dialogoDeDate.show();
        }
    }

    //Guardar informacion
    public void saveOnClick(View view){

        String nuevoTitulo = nuevoTituloTexto.getText().toString();
        String nuevaDescrip = nuevaDescripTexto.getText().toString();
        String nuevoDueDate = dateTexto.getText().toString();
        boolean nuevoComplete = completeBox.isChecked();

        Obj nuevoObj = new Obj(nuevoTitulo, nuevaDescrip, nuevoDueDate, nuevoComplete);

        Intent intent = new Intent(this, ActivityLogObj.class);
        intent.putExtra("nuevoObj", nuevoObj);
        Toast.makeText(this,"Nuevo Objetivo guardado!", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }



}
