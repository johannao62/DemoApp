package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.miempresa.demoapp.database.UDataBase;
import com.miempresa.demoapp.database.dao.UserDao;
import com.miempresa.demoapp.database.entity.User;

public class OlvideContrasena extends AppCompatActivity {

    private TextInputLayout txtInputEmail;

    private EditText edtMail;

    String PASS_TMP = "123456";

    //DB
    UDataBase uDataBase;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvide_contrasena);

        //Se crea la instancia a la base de datos
        uDataBase = UDataBase.getInstance(this);
        userDao = uDataBase.getAllDao();

        edtMail = findViewById(R.id.edtMail);
        txtInputEmail = findViewById(R.id.txtInputEmail);
    }

    public void CargarFormulario(View v){
        //Se capturan los datos del formulario
        System.out.println("Se ingresa a cargar formulario");

        if (validar()){
            toastCorrecto("Su contraseña temporal es: " + PASS_TMP);

        }else{
            toastError("Debe llenar la info");
        }

    }

    private boolean validar() {
        boolean retorno = true;
        String correo;

        correo = edtMail.getText().toString();

        if (correo.isEmpty()) {
            txtInputEmail.setError("Ingresar correo electrónico");
            retorno = false;
        } else {
            txtInputEmail.setErrorEnabled(false);
        }

        if(retorno) {
            //Se registra el usuario
            userDao.updatePassByUserEmail(correo, PASS_TMP);
        }

        return retorno;
    }

    public void RegresarAMain(View v){
        //Se declara la pantalla o Activity, que se va a invocar:
        //Intent intActPpal = new Intent(this, MainActivity.class); //Se invoca la actividad
        //startActivity(intActPpal);
        finish();

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
}