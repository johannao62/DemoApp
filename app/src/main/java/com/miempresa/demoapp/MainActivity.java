package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText clave;
    private String claveCorrecta = "estaEs";
    private String usuarioCorrecto = "Jo@gmail.com";

    String mensajeOk = "Sesión Iniciada Correctamente";

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
            //Toast.makeText(this, "Bienvenido a la My App Android", Toast.LENGTH_LONG).show();
            toastCorrecto(mensajeOk);
        } else {
            Toast.makeText(this, "Usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show();
        }



    }

    public void toastCorrecto(String msg){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_ok,(ViewGroup) findViewById(R.id.ll_custom_toast_ok));
        TextView txtMensaje = view.findViewById(R.id.txtMensajeToast1);

        txtMensaje.setText(msg);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL |Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

}