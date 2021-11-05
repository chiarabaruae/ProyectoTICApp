package com.example.miapp;

import java.util.ArrayList;

public class ObjList {
    private ArrayList<Obj> list;

    public ObjList(){
        list = new ArrayList<>();
    }

    public ArrayList<Obj> getList() {
        return new ArrayList<>(list);
    }
}
