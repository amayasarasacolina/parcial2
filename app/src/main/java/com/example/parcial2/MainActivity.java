package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAgregar = findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),recetas.class);

                startActivity(intento);
            }
        });

        Button btnBorrar= findViewById(R.id.btnObtener);
        CRUDRecetas CRUD = new CRUDRecetas(this);
        ArrayList<String> listaRecetitas = new ArrayList<String>();
        //CRUD.insertarReceta("Chilaquiles", "rica comida casera");

        ListView listaRecetas=findViewById(R.id.listarecetas);
        Cursor informacion=CRUD.mostrarRecetas();

        while (informacion.moveToNext()){
            String titulo=informacion.getString(1);
            String id=informacion.getString(0);
            listaRecetitas.add(titulo+id);



        }
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaRecetitas);
        listaRecetas.setAdapter(adaptador);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUD.eliminarReceta(1);
            }
        });

        Button btnEliminar= findViewById(R.id.btnObtener);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),eliminar.class);

                startActivity(intento);
            }
        });

        Button btnEditar= findViewById(R.id.btnEditarReceta);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),editar.class);

                startActivity(intento);
            }
        });


    }
}