package com.example.pc.proyecto;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * Created by PC on 18/05/2017.
 */


public class SombreroActivity extends AppCompatActivity {

    private ListView listaPersonalizada = null;
    private ArrayList<Item> arrayItem = null;
    private ListViewAdapter adapter = null;
    private ImageButton ibAbrirMarcado;
    private ImageButton ibEnviarMail;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sombrero);

        listaPersonalizada = (ListView) findViewById(R.id.lvLista);
        arrayItem = new ArrayList<>();
        cargarLista();

        ibAbrirMarcado = (ImageButton) findViewById(R.id.ibAbrirMarcado);
        ibAbrirMarcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirMarcadoTelefonico();
            }
        });
        ibEnviarMail = (ImageButton) findViewById(R.id.ibEnviarEmail);
        ibEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMail();
            }
        });







    }

    private  void cargarLista(){
        arrayItem.add(new Item(R.drawable.s2,getResources().getString(R.string.s1), getResources().getString(R.string.s1_1)));
        arrayItem.add(new Item(R.drawable.s3,getResources().getString(R.string.s2), getResources().getString(R.string.s2_2)));
        arrayItem.add(new Item(R.drawable.s4,getResources().getString(R.string.s3), getResources().getString(R.string.s3_3)));
        arrayItem.add(new Item(R.drawable.s5,getResources().getString(R.string.s4), getResources().getString(R.string.s4_4)));
        arrayItem.add(new Item(R.drawable.s6,getResources().getString(R.string.s5), getResources().getString(R.string.s5_5)));
        arrayItem.add(new Item(R.drawable.s7,getResources().getString(R.string.s6), getResources().getString(R.string.s6_6)));
        arrayItem.add(new Item(R.drawable.s8,getResources().getString(R.string.s7), getResources().getString(R.string.s7_7)));
        arrayItem.add(new Item(R.drawable.s9,getResources().getString(R.string.s8), getResources().getString(R.string.s8_8)));
        arrayItem.add(new Item(R.drawable.s1,getResources().getString(R.string.s9), getResources().getString(R.string.s9_9)));
        arrayItem.add(new Item(R.drawable.s10,getResources().getString(R.string.s10), getResources().getString(R.string.s10_10)));


        adapter = new ListViewAdapter(arrayItem,this);
        listaPersonalizada.setAdapter(adapter);
    }
    public void enviarMail() {

        String [] TO = {"lizeth.c.caceres@gmail.com"};
        String asunto = "precio del producto:";
        String contenido = " Descripcion del producto ";

        intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, TO);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, contenido);

        startActivity(Intent.createChooser(intent, "Envia Correo"));
    }
    public void abrirMarcadoTelefonico() {
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:68155732"));
        startActivity(intent);
    }


}





