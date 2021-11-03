package com.example.miapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {

    private EditText Name = null;
    private EditText Password = null;
    private Button Ingresar;
    private int cont = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Name = (EditText) findViewById(R.id.editTextTextPersonName);
    Password = (EditText) findViewById(R.id.editTextNumberPassword);
    }

    public void validacion(View view){

        Ingresar = (Button)findViewById(R.id.Ingresar);

        String UserName = Name.getText().toString();
        String UserPassword = Password.getText().toString();

        if ((UserName.equals("user1") && UserPassword.equals("pass1"))) {
            Intent i = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(i);
        } else {
            //desabilitar boton
            cont--;
            if(cont==0){
               Ingresar.setEnabled(false);
           }
        }
    }
    }

