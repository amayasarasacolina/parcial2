package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class recetas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas);

        Button btnAgregar= findViewById(R.id.btnAgregar);
        EditText titulo=findViewById(R.id.titulo);
        EditText descripcion=findViewById(R.id.descripcion);
        CRUDRecetas CRUD = new CRUDRecetas(this);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CRUD.insertarReceta(titulo.getText().toString(),descripcion.getText().toString());

                Intent intento=new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intento);
            }
        });
    }



}