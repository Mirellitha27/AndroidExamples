package com.mireya.realmejm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mireya.realmejm.crud.CRUDProfesor;
import com.mireya.realmejm.model.Profesor;

import io.realm.Realm;
import io.realm.RealmObject;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, email;
    private Button save, read, readName, readId, update;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView() {
        profesor = new Profesor();
        nombre = findViewById(R.id.EdNombre);
        email = findViewById(R.id.EdEmail);
        save = findViewById(R.id.btnSave);
        readId = findViewById(R.id.btnReadId);
        update = findViewById(R.id.btnUpdate);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profesor.setName(nombre.getText().toString());
                profesor.setEmail(email.getText().toString());
                CRUDProfesor.addProfesor(profesor);
            }
        });

        read = findViewById(R.id.btnRead);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getAllProfesor();
            }
        });

        readName = findViewById(R.id.btnReadName);
        readName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorByName(nombre.getText().toString());
            }
        });

        readId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.getProfesorById(Integer.parseInt(nombre.getText().toString()));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CRUDProfesor.updateProfesor(1);
            }
        });
    }
}
