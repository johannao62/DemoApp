package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Agenda extends AppCompatActivity {

    private TextView tvUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        //Se capturan los objetos de la interfaz gráfica
        tvUsuario = findViewById(R.id.tvUsuario);


        //Se recupera el dato enviado
        tvUsuario.setText(getIntent().getStringExtra("usuario"));
    }
}