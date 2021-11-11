package com.example.miapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {

    private EditText Name = null;
    private EditText Password = null;
    private Button Ingresar;
    private int cont = 0;


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

