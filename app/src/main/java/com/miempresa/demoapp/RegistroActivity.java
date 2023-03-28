package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistroActivity extends AppCompatActivity {

    private AutoCompleteTextView dropdownTipoDoc, dropdownDepartamento, dropdownProvincia, dropdownDistrito;
    private EditText edtNameUser, edtNumDocU, edtTelefonoU,
            edtDireccionU, edtPasswordUser, edtEmailUser;
    private TextInputLayout txtInputNameUser, txtInputApellidoPaternoU, txtInputApellidoMaternoU,
            txtInputTipoDoc, txtInputNumeroDocU, txtInputDepartamento, txtInputProvincia,
            txtInputDistrito, txtInputTelefonoU, txtInputDireccionU, txtInputEmailUser, txtInputPasswordUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //Se capturan los objetos de la interfaz gráfica
        edtNameUser = findViewById(R.id.edtNameUser);
        edtNumDocU = findViewById(R.id.edtNumDocU);
        edtTelefonoU = findViewById(R.id.edtTelefonoU);
        edtDireccionU = findViewById(R.id.edtDireccionU);
        edtPasswordUser = findViewById(R.id.edtPasswordUser);
        edtEmailUser = findViewById(R.id.edtEmailUser);
        //AutoCompleteTextView
        dropdownTipoDoc = findViewById(R.id.dropdownTipoDoc);
        dropdownDepartamento = findViewById(R.id.dropdownDepartamento);
        dropdownProvincia = findViewById(R.id.dropdownProvincia);
        //TextInputLayout
        txtInputNameUser = findViewById(R.id.txtInputNameUser);
        txtInputTipoDoc = findViewById(R.id.txtInputTipoDoc);
        txtInputNumeroDocU = findViewById(R.id.txtInputNumeroDocU);
        txtInputDepartamento = findViewById(R.id.txtInputDepartamento);
        txtInputProvincia = findViewById(R.id.txtInputProvincia);
        txtInputTelefonoU = findViewById(R.id.txtInputTelefonoU);
        txtInputDireccionU = findViewById(R.id.txtInputDireccionU);
        txtInputEmailUser = findViewById(R.id.txtInputEmailUser);
        txtInputPasswordUser = findViewById(R.id.txtInputPasswordUser);

        String[] arrayTipoDoc = {
                "Cedula",
                "Nit",
                "Cedula Extranjería",
                "Pasaporte",
                "Tarjeta de Identidad"
        };

        String[] arrayDepartamentos = {
                "Valle del Cauca",
                "Antioquia",
                "Cundinamarca"
        };

        String[] arrayCiudad = {
                "Cali",
                "Medellín",
                "Bogotá"
        };

        //Adaptador para conectarse al spinner Tipo Documento
        ArrayAdapter<String> AdaptadorTipoDoc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayTipoDoc);
        dropdownTipoDoc.setAdapter(AdaptadorTipoDoc);

        //Adaptador para conectarse al spinner Departamentos
        ArrayAdapter<String> AdaptadorDepartamentos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayCiudad);
        dropdownProvincia.setAdapter(AdaptadorDepartamentos);

        //Adaptador para conectarse al spinner Ciudad
        ArrayAdapter<String> AdaptadorCiudad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayDepartamentos);
        dropdownDepartamento.setAdapter(AdaptadorDepartamentos);

        System.out.println("SPINNER SELECCIONADO"+dropdownTipoDoc.getOnItemSelectedListener());
    }

    public void RegresarAMain(View v){
        //Se declara la pantalla o Activity, que se va a invocar:
        Intent intActPpal = new Intent(this, MainActivity.class); //Se invoca la actividad
        startActivity(intActPpal);

    }

    public void CargarFormulario(View v){
        //Se capturan los datos del formulario
        System.out.println("Se ingresa a cargar formulario");

        if (validar()){
            toastCorrecto("Se han ingresado los datos");

        }else{
            toastError("Debe llenar la info");
        }

    }

    private boolean validar() {
        boolean retorno = true;
        String nombres, apellidoPaterno, apellidoMaterno, numDoc, telefono, direccion, correo, clave,
                dropTipoDoc, dropDepartamento, dropProvincia, dropDistrito;
        nombres = edtNameUser.getText().toString();
        numDoc = edtNumDocU.getText().toString();
        telefono = edtTelefonoU.getText().toString();
        direccion = edtDireccionU.getText().toString();
        correo = edtEmailUser.getText().toString();
        clave = edtPasswordUser.getText().toString();

        dropTipoDoc = dropdownTipoDoc.getText().toString();
        dropDepartamento = dropdownDepartamento.getText().toString();
        dropProvincia = dropdownProvincia.getText().toString();

        if (nombres.isEmpty()) {
            txtInputNameUser.setError("Ingresar nombres");
            retorno = false;
        } else {
            txtInputNameUser.setErrorEnabled(false);
        }

        if (dropTipoDoc.isEmpty()) {
            txtInputTipoDoc.setError("Seleccionar Tipo Doc");
            retorno = false;
        } else {
            txtInputTipoDoc.setErrorEnabled(false);
        }

        if (numDoc.isEmpty()) {
            txtInputNumeroDocU.setError("Ingresar número documento");
            retorno = false;
        } else {
            txtInputNumeroDocU.setErrorEnabled(false);
        }

        if (dropDepartamento.isEmpty()) {
            txtInputDepartamento.setError("Seleccionar Departamento");
            retorno = false;
        } else {
            txtInputDepartamento.setErrorEnabled(false);
        }

        if (dropProvincia.isEmpty()) {
            txtInputProvincia.setError("Seleccionar Ciudad");
            retorno = false;
        } else {
            txtInputProvincia.setErrorEnabled(false);
        }

        if (direccion.isEmpty()) {
            txtInputDireccionU.setError("Ingresar dirección de su casa");
            retorno = false;
        } else {
            txtInputDireccionU.setErrorEnabled(false);
        }
        if (correo.isEmpty()) {
            txtInputEmailUser.setError("Ingresar correo electrónico");
            retorno = false;
        } else {
            txtInputEmailUser.setErrorEnabled(false);
        }
        if (clave.isEmpty()) {
            txtInputPasswordUser.setError("Ingresar clave para el inicio de sesión");
            retorno = false;
        } else {
            txtInputPasswordUser.setErrorEnabled(false);
        }

        return retorno;
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