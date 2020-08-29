package com.sudev.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    TextView tvNombre, tvFechaNacimiento, tvTelefono, tvEmail, tvDescripcion;
    Button btnEditarDatos;
    String dia, mes, anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        tvNombre = findViewById(R.id.tvNombreApellidos);
        tvFechaNacimiento = findViewById(R.id.tvFechaNacimientoConfirmar);
        tvTelefono = findViewById(R.id.tvTelefonoConfirmar);
        tvEmail = findViewById(R.id.tvEmailConfirmar);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);

        Bundle parametros = getIntent().getExtras();
        assert parametros != null;
        tvNombre.setText(parametros.getString("nombre"));
        tvFechaNacimiento.setText( parametros.getString("fecha"));
        tvTelefono.setText( parametros.getString("telefono"));
        tvEmail.setText( parametros.getString("email"));
        tvDescripcion.setText( parametros.getString("descripcion"));
        dia = parametros.getString("dia");
        mes = parametros.getString("mes");
        anio = parametros.getString("anio");

        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
                intent.putExtra("nombreEdit",tvNombre.getText().toString());
                intent.putExtra("telefonoEdit",tvTelefono.getText().toString());
                intent.putExtra("emailEdit", tvEmail.getText().toString());
                intent.putExtra("descripcionEdit",tvDescripcion.getText().toString());
                intent.putExtra("diaEdit", dia);
                intent.putExtra("mesEdit", mes);
                intent.putExtra("anioEdit", anio);
                startActivity(intent);
            }
        });
    }
}