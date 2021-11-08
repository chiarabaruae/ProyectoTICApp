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

    @Override
    public void onClick(View button) {
        if (button == botonElegirFecha){
            final Calendar calendario = Calendar.getInstance();
            anho = calendario.get(Calendar.YEAR);
            mes = calendario.get(Calendar.MONTH);
            dia = calendario.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialogoDeDate = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    {
                        @Override
                                public void on
                    }
                }
            })
        }
    }

    // visualizacion de la pantalla para el botón de "Return"
    public void setTypeView(View view){
        setContentView(R.layout.activity_type_view);
    }

    // tener un arrayList
    TypeToken<ArrayList<Obj>> objArrayList = new TypeToken<ArrayList<Obj>>(){};

}
