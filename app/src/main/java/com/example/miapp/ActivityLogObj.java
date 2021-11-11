package com.example.miapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.app.DatePickerDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;

public class ActivityLogObj extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Obj> miObjList;
    private SharedPreferences sharedPref;

    //muestreo de pantallas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_view);
    }

    //Pantallas de Botones
    //Boton lista desgun prioridad
    public void setViewListObjs(View Button){ setContentView(R.layout.activity_lis_item2); }

    //Boton vista en total
    public void setViewObjList(View button){
        setContentView(R.layout.activity_objlist);
    }

    public void onNewSave(View button){

        Button btn;

        setContentView(R.layout.activity_objlist);

        btn = (Button)findViewById(R.id.save_button);
        btn.setOnClickListener(this);

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

        ObjListAdapter objListAdapter = new ObjListAdapter(this, miObjList);

        ListView listview = (ListView) findViewById(R.id.ListadoObjetivos);
        listview.setAdapter(objListAdapter);

        Toast.makeText(ActivityLogObj.this, "Objetivo Guardado", Toast.LENGTH_SHORT).show();
    }

    public void modifObjList(ArrayList<Obj> list){

        if (getIntent().getExtras() != null){
            Obj newObj = (Obj) getIntent().getExtras().get("newObj");

            boolean found = false;
            int cont = 0;

            for(Obj obj:list) {
                if (obj.getTitulo().equals(newObj.getTitulo())) {
                    found = true;
                    break;
                }
                cont++;
            }

            if(found){
                list.remove(cont);
                list.add(cont, newObj);
            }else{
                list.add(newObj);
            }
        }
    }

    private Button botonNot;
    private PendingIntent pendingIntent;
    private final static String c_id = "notificacion";
    private final static int not_id = 0;


    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.app_name);
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(c_id, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void createNotificacion(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),c_id);
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setContentTitle("Notificacion Android");
        builder.setContentText("Revisa tus Objetivos");
        builder.setColor(Color.RED);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(not_id, builder.build());
    }


    public void onAddButtonClick(View button) {
        Intent intent = new Intent(this, ActivityLogObj.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View listItem) {
        Obj obj = (Obj) listItem.getTag();
        Intent intent = new Intent(this, ActivityObjDetails.class);
        intent.putExtra("obj", obj);
        startActivity(intent);
    }
}
