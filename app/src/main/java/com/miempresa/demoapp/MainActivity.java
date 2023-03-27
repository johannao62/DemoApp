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

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText clave;
    private String claveCorrecta = "estaEs";
    private String usuarioCorrecto = "Jo@gmail.com";
    private EditText edtMail, edtPassword;
    private TextInputLayout txtInputUsuario, txtInputPassword;



    String mensajeOk = "Excelente, Haz Iniciado Sesión";
    String mensajeError = "Error: Usuario o contraseña Incorrectos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.edtMail);
        clave = findViewById(R.id.edtPassword);
        edtMail = findViewById(R.id.edtMail);
        edtPassword = findViewById(R.id.edtPassword);
        txtInputUsuario = findViewById(R.id.txtInputUsuario);
        txtInputPassword = findViewById(R.id.txtInputPassword);

    }

    public void AutenticaUsuario(View v){

        if (validar()){
            if (usuario.getText().toString().equalsIgnoreCase(usuarioCorrecto)
                    && clave.getText().toString().equals(claveCorrecta)
            ){
                //Se muestra un mensaje emergente de bienvenida
                //Toast.makeText(this, "Bienvenido a la My App Android", Toast.LENGTH_LONG).show();
                toastCorrecto(mensajeOk);
            } else {
                //Toast.makeText(this, "Usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show();
                toastError(mensajeError);
            }

        }else {
            toastError("Por favor, complete todos los campos.");
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

    public void toastError(String msg){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_error,(ViewGroup) findViewById(R.id.ll_custom_toast_error));
        TextView txtMensaje = view.findViewById(R.id.txtMensajeToast2);

        txtMensaje.setText(msg);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL |Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    private boolean validar() {
        boolean retorno = true;
        String user, passw;
        user = edtMail.getText().toString();
        passw = edtPassword.getText().toString();
        if (user.isEmpty()) {
            txtInputUsuario.setError("Ingrese su usario y/o correo electrónico");
            retorno = false;
        } else {
            txtInputUsuario.setErrorEnabled(false);
        }
        if (passw.isEmpty()) {
            txtInputPassword.setError("Ingrese su contraseña");
            retorno = false;
        } else {
            txtInputPassword.setErrorEnabled(false);
        }
        return retorno;
    }

}