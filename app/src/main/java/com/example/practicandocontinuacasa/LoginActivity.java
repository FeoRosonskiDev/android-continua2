package com.example.practicandocontinuacasa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText contrasena;
    private Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        contrasena = findViewById(R.id.txtContrasena);
        ingresar = findViewById(R.id.btnIngresar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validarUsuario())
                {
                    Intent menu = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(menu);
                }
                else{
                    mensajeError();
                }
            }
        });
    }

    private boolean validarUsuario()
    {
        return usuario.getText().toString().equals("Jordi") &&
            contrasena.getText().toString().equals("admin");
    }

    private void mensajeError()
    {
        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos",
                Toast.LENGTH_SHORT).show();
    }
}
