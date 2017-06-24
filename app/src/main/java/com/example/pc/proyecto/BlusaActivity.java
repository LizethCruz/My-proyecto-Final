package com.example.pc.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class BlusaActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_blusa);
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
        arrayItem.add(new Item(R.drawable.b1,getResources().getString(R.string.b1), getResources().getString(R.string.b1_1)));
        arrayItem.add(new Item(R.drawable.b2,getResources().getString(R.string.b2),getResources().getString(R.string.b2_2)));
        arrayItem.add(new Item(R.drawable.b3,getResources().getString(R.string.b3),getResources().getString(R.string.b3_3)));
        arrayItem.add(new Item(R.drawable.b4,getResources().getString(R.string.b4),getResources().getString(R.string.b4_4)));
        arrayItem.add(new Item(R.drawable.b5,getResources().getString(R.string.b5),getResources().getString(R.string.b5_5)));
        arrayItem.add(new Item(R.drawable.b6,getResources().getString(R.string.b6),getResources().getString(R.string.b6_6)));
        arrayItem.add(new Item(R.drawable.b7,getResources().getString(R.string.b7),getResources().getString(R.string.b7_7)));
        arrayItem.add(new Item(R.drawable.b8,getResources().getString(R.string.b8),getResources().getString(R.string.b8_8)));
        arrayItem.add(new Item(R.drawable.b9,getResources().getString(R.string.b9),getResources().getString(R.string.b9_9)));
        arrayItem.add(new Item(R.drawable.b10,getResources().getString(R.string.b10),getResources().getString(R.string.b10_10)));





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






