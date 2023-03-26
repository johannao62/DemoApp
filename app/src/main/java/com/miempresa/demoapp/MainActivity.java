package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText clave;
    private String claveCorrecta = "estaEs";
    private String usuarioCorrecto = "Jo@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.edtMail);
        clave = findViewById(R.id.edtPassword);

    }

    public void AutenticaUsuario(View v){

        if (usuario.getText().toString().equalsIgnoreCase(usuarioCorrecto)
                && clave.getText().toString().equals(claveCorrecta)
        ){
            //Se muestra un mensaje emergente de bienvenida
            Toast.makeText(this, "Bienvenido a la My App Android", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show();
        }

    }

}