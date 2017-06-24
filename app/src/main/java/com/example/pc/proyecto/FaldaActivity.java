package com.example.pc.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class FaldaActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_falda);
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
        arrayItem.add(new Item(R.drawable.f1,getResources().getString(R.string.f1), getResources().getString(R.string.f1_1)));
        arrayItem.add(new Item(R.drawable.f2,getResources().getString(R.string.f2), getResources().getString(R.string.f2_2)));
        arrayItem.add(new Item(R.drawable.f3,getResources().getString(R.string.f3), getResources().getString(R.string.f3_3)));
        arrayItem.add(new Item(R.drawable.f4,getResources().getString(R.string.f4), getResources().getString(R.string.f4_4)));
        arrayItem.add(new Item(R.drawable.f5,getResources().getString(R.string.f5), getResources().getString(R.string.f5_5)));
        arrayItem.add(new Item(R.drawable.f6,getResources().getString(R.string.f6), getResources().getString(R.string.f6_6)));
        arrayItem.add(new Item(R.drawable.f7,getResources().getString(R.string.f7), getResources().getString(R.string.f7_7)));
        arrayItem.add(new Item(R.drawable.f8,getResources().getString(R.string.f8), getResources().getString(R.string.f8_8)));
        arrayItem.add(new Item(R.drawable.f9,getResources().getString(R.string.f9), getResources().getString(R.string.f9_9)));
        arrayItem.add(new Item(R.drawable.f10,getResources().getString(R.string.f10), getResources().getString(R.string.f10_10)));


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





