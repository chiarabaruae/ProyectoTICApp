package com.example.miapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class ActivityObjDetails extends AppCompatActivity{

    private TextView titulo;
    private TextView descripcion;
    private TextView due_Date;
    private CheckBox complete;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_obj);

        titulo = (TextView)findViewById(R.id.new_task_title);
        descripcion = (TextView)findViewById(R.id.new_task_description);
        due_Date = (TextView)findViewById(R.id.due_date);
        complete = (CheckBox)findViewById(R.id.completeBox);

        Obj obj = (Obj)getIntent().getExtras().get("obj");
        titulo.setText(obj.getTitulo());
        descripcion.setText(obj.getDescripcion());
        due_Date.setText(obj.getDueDate());
        complete.setChecked(obj.getComplete());
    }

    public void onEditButton(View view){
        String tituloString = titulo.getText().toString();
        String descripcionString = descripcion.getText().toString();
        String dueDateString = due_Date.getText().toString();
        boolean isComplete = complete.isChecked();

        Intent newObj = new Intent(this, ActivityList.class);
        getIntent().putExtra("newObj", newObj);
        Toast.makeText(this, "Objetivo Actualizado!", Toast.LENGTH_SHORT).show();
        startActivity(newObj);
    }

}
