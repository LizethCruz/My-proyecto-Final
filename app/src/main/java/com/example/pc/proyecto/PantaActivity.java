package com.example.pc.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class PantaActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_panta);

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
        arrayItem.add(new Item(R.drawable.p1,getResources().getString(R.string.p1), getResources().getString(R.string.p1_1)));
        arrayItem.add(new Item(R.drawable.p2,getResources().getString(R.string.p2), getResources().getString(R.string.p2_2)));
        arrayItem.add(new Item(R.drawable.p3,getResources().getString(R.string.p3), getResources().getString(R.string.p3_3)));
        arrayItem.add(new Item(R.drawable.p4,getResources().getString(R.string.p4), getResources().getString(R.string.p4_4)));
        arrayItem.add(new Item(R.drawable.p5,getResources().getString(R.string.p5), getResources().getString(R.string.p5_5)));
        arrayItem.add(new Item(R.drawable.p6,getResources().getString(R.string.p6), getResources().getString(R.string.p6_6)));
        arrayItem.add(new Item(R.drawable.p7,getResources().getString(R.string.p7), getResources().getString(R.string.p7_7)));
        arrayItem.add(new Item(R.drawable.p8,getResources().getString(R.string.p8), getResources().getString(R.string.p8_8)));


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





