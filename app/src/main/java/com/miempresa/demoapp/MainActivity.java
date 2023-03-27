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
    private EditText edtMail, edtPassword;
    private String claveCorrecta = "estaEs";
    private String usuarioCorrecto = "Jo@gmail.com";
    private TextView txtNuevoUsuario;

    private TextInputLayout txtInputUsuario, txtInputPassword;
    String mensajeOk = "Excelente, Haz Iniciado Sesión";
    String mensajeError = "Error: Usuario o contraseña Incorrectos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se capturan los objetos de la interfaz gráfica
        usuario = findViewById(R.id.edtMail);
        clave = findViewById(R.id.edtPassword);
        edtMail = findViewById(R.id.edtMail);
        edtPassword = findViewById(R.id.edtPassword);
        txtInputUsuario = findViewById(R.id.txtInputUsuario);
        txtInputPassword = findViewById(R.id.txtInputPassword);
        txtNuevoUsuario = findViewById(R.id.txtNuevoUsuario);

    }

    public void AutenticaUsuario(View v){

        //Metodo Attached al botón loguin, que genera la operación de loguin

        if (validar()){
            //Mediante el método validar se revisa que los campos hayan sido ingresados correctamente.
            if (usuario.getText().toString().equalsIgnoreCase(usuarioCorrecto)
                    && clave.getText().toString().equals(claveCorrecta)
            ){
                //Se muestra un mensaje emergente de bienvenida
                //Toast.makeText(this, "Bienvenido a la My App Android", Toast.LENGTH_LONG).show();
                toastCorrecto(mensajeOk);

                //Se declara cual es la activity (pantalla) qué será invoncada.
                Intent intAgenda = new Intent(this,Agenda.class);

                //Se transfiere un dato hacia la activity destino
                intAgenda.putExtra("usuario",usuario.getText().toString());

                //Se invoca la Activity destino
                startActivity(intAgenda);

            } else {
                //Toast.makeText(this, "Usuario o Contraseña incorrecta", Toast.LENGTH_LONG).show();
                toastError(mensajeError);
            }

        }else {
            //Si la validación indica que algún campo está vacío, emite este mensaje
            toastError("Por favor, complete todos los campos.");
        }

        //Se genera el método para pasar a la Activity de Registro.
        txtNuevoUsuario.setOnClickListener( vw -> {
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
        });

    }

    public void toastCorrecto(String msg){
        //Toast personalizado con color para mostrar el mensaje emergente de ingreso exitoso
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
        //Toast personalizado con color para mostrar el mensaje emergente de Credenciales Inválidas
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
        //Validación de campos vacíos en el loguin
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