package com.mireya.realmejm.crud;

import android.util.Log;

import com.mireya.realmejm.model.Profesor;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CRUDProfesor {
    private final static  int calculateImdex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Profesor.class).max("id");
        int nextId;
        if (currentIdNum == null){
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue()+ 1;
        }
        return nextId;
    }

    public final static void addProfesor(final Profesor profesor){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CRUDProfesor.calculateImdex();
                Profesor realmProfesor = realm.createObject(Profesor.class, index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });
    }

    public final static List<Profesor> getAllProfesor(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
        for (Profesor profesor: profesors){
            Log.d("TAG", " id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesors;
    }

    public final static Profesor getProfesorByName(String name){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name", name).findFirst();
        if (profesor != null){
            Log.d("TAG", " id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesor;
    }
    public final static Profesor getProfesorById(int id){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        if (profesor != null){
            Log.d("TAG", " id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
        return profesor;
    }

    public final static void updateProfesor(int id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        profesor.setName("bb luis");
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();
        if (profesor != null){
            Log.d("TAG", " id: " + profesor.getId() + " Nombre: " + profesor.getName() + " Email: " + profesor.getEmail());
        }
    }
}
