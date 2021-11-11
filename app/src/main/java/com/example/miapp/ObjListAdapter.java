package com.example.miapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ObjListAdapter extends ArrayAdapter<Obj> {
    public ObjListAdapter(Context context, ArrayList<Obj> objetivos){
        super(context, 0, objetivos);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_objlist, parent, false);
        }
        Obj currentObj = getItem(position);

        TextView title_item = (TextView) listItemView.findViewById(R.id.new_task_title);
        title_item.setText(currentObj.getTitulo());

        listItemView.setTag(currentObj);

        return listItemView;
    }
}
