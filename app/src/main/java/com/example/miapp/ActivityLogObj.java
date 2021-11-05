package com.example.miapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLogObj extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_view);

    }
    public void onViewAllButtonClicked(View Button){
        setContentView(R.layout.activity_lis_item2);
    }

    public void onSaveNewButtonClicked(View button){
        setContentView(R.layout.activity_objlist);
    }

}
