package com.example.pc.proyecto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by PC on 18/05/2017.
 */

public class ListadoActivity extends AppCompatActivity {

    private ImageButton ima1;
    private ImageButton ima2;
    private ImageButton ima3;
    private ImageButton ima4;
    private ImageButton ima5;
    private ImageButton ima6;

    int id;

    public int getId() {
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_listado);

        ima1 = (ImageButton) findViewById(R.id.som);
        ima2 = (ImageButton) findViewById(R.id.blus);
        ima3 = (ImageButton) findViewById(R.id.falda);
        ima4 = (ImageButton) findViewById(R.id.panta);
        ima5 = (ImageButton) findViewById(R.id.zapato);
        ima6 = (ImageButton) findViewById(R.id.bolsa);



        ima1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SombreroActivity.class);
                startActivity(i);
            }
        });

        ima2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),BlusaActivity.class);
                startActivity(i);
            }
        });

        ima3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FaldaActivity.class);
                startActivity(i);
            }
        });

        ima4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PantaActivity.class);
                startActivity(i);
            }
        });

        ima5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CalzadoActivity.class);
                startActivity(i);
            }
        });

        ima6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CarteraActivity.class);
                startActivity(i);
            }
        });


    }
public void prog(View v){
    Intent i = new Intent(getApplicationContext(),DatosActivity.class);
    startActivity(i);
}


    }

