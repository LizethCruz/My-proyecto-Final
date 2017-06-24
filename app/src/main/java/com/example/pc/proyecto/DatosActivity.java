package com.example.pc.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_datos);
    }
}
