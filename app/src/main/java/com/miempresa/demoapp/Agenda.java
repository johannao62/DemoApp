package com.miempresa.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.miempresa.demoapp.database.UDataBase;
import com.miempresa.demoapp.database.dao.UserDao;
import com.miempresa.demoapp.database.entity.User;

public class Agenda extends AppCompatActivity {

    private TextView tvUsuario;

    private TextView tvTipoIdentificacion;

    private TextView tvIdentificacion;

    private TextView tvEmail;

    private TextView tvCiudad;

    //DB
    UDataBase uDataBase;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        //Se crea la instancia a la base de datos
        uDataBase = UDataBase.getInstance(this);
        userDao = uDataBase.getAllDao();

        //Se capturan los objetos de la interfaz gráfica
        tvUsuario = findViewById(R.id.tvUsuario);
        tvEmail = findViewById(R.id.tvEmail);
        tvCiudad = findViewById(R.id.tvCiudad);
        tvTipoIdentificacion = findViewById(R.id.tvTypeIdentificacion);
        tvIdentificacion = findViewById(R.id.tvIdentificacion);

        //Se recupera el dato enviado
        String userEmail = getIntent().getStringExtra("usuario");

        User user = userDao.getUserByEmail(userEmail);

        tvUsuario.setText(user.getUserName());
        tvEmail.setText(user.getUserEmail());
        tvCiudad.setText(user.getUserCity());
        tvTipoIdentificacion.setText(user.getUserIdentificationType());
        tvIdentificacion.setText(user.getUserIdentificationNumber());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_agenda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.exit_to_app:
                //Elimina el estado de todas las sesiones
                userDao.closeAllSesion();
                //Regresa a la pantalla de inicio de sesión
                Intent intAgenda = new Intent(this,MainActivity.class);
                startActivity(intAgenda);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}