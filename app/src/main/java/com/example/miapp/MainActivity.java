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
        setContentView(R.layout.activity_title);

    }

    public void setView(View view){
        setContentView(R.layout.activity_title);
    }

    public void onViewAllButtonClicked(View Button){
        Intent intent = new Intent(this, ActivityLogObj.class);
        startActivity(intent);
    }

    public void onSaveNewButtonClicked(View button){
        Intent intent = new Intent(this, ActivityList.class);
        startActivity(intent);
    }

    public void onSetInfoButton(View button){
        setContentView(R.layout.activity_info);
    }
}

