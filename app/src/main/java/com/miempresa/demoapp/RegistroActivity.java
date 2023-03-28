package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

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
    }

    public void CargarFormulario(View v){
        float num1=0f;
        float num2=0f;
        System.out.println("Se ingresa a cargar formulario");
    }

    public void RegresarAMain(View v){
        //Se declara la pantalla o Activity, que se va a invocar:
        Intent intActPpal = new Intent(this, MainActivity.class); //Se invoca la actividad
        startActivity(intActPpal);

    }

}