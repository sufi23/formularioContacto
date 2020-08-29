package com.sudev.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nombre, telefono, email, descripcion;
    String dia, mes, anio;
    DatePicker pickerNacimiento;
    Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.etNombreCompleto);
        telefono = findViewById(R.id.etTelefono);
        email = findViewById(R.id.etEmail);
        descripcion = findViewById(R.id.etDescripcionContacto);
        siguiente = findViewById(R.id.btnSiguiente);
        pickerNacimiento = findViewById(R.id.datePicker);

        Bundle parametrosEdit = getIntent().getExtras();
        if (parametrosEdit != null){
            nombre.setText(parametrosEdit.getString("nombreEdit"));
            telefono.setText(parametrosEdit.getString("telefonoEdit"));
            email.setText(parametrosEdit.getString("emailEdit"));
            descripcion.setText(parametrosEdit.getString("descripcionEdit"));
        }


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("telefono",telefono.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("descripcion",descripcion.getText().toString());
                intent.putExtra("fecha", pickerNacimiento.getDayOfMonth()+"/"+pickerNacimiento.getMonth()+"/"+pickerNacimiento.getYear());
                intent.putExtra("dia", pickerNacimiento.getDayOfMonth());
                intent.putExtra("mes", pickerNacimiento.getMonth());
                intent.putExtra("anio", pickerNacimiento.getYear());
                startActivity(intent);
            }
        });

    }
}