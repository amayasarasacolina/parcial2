package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        EditText ID2=findViewById(R.id.ID2);
        EditText titulo=findViewById(R.id.titulo2);
        EditText descripcion=findViewById(R.id.descripcion2);
        Button btnEditar= findViewById(R.id.btnEditar);
        CRUDRecetas CRUD = new CRUDRecetas(this);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUD.actualizarReceta(Integer.parseInt(String.valueOf(ID2.getText())),titulo.getText().toString(),descripcion.getText().toString());
                Intent intento=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intento);
            }
        });
    }
}