package com.example.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class eliminar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);


        Button btnBorrar= findViewById(R.id.btnObtener);
        CRUDRecetas CRUD = new CRUDRecetas(this);
        EditText ID=findViewById(R.id.ID);

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUD.eliminarReceta(Integer.parseInt(String.valueOf(ID.getText())));
                Intent intento=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intento);
            }
        });
    }
}