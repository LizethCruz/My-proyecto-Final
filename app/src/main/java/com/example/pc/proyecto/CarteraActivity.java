package com.example.pc.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class CarteraActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_cartera);
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
        arrayItem.add(new Item(R.drawable.c1,getResources().getString(R.string.bo1), getResources().getString(R.string.bo1_1)));
        arrayItem.add(new Item(R.drawable.c3,getResources().getString(R.string.bo2), getResources().getString(R.string.bo2_2)));
        arrayItem.add(new Item(R.drawable.c4,getResources().getString(R.string.bo3), getResources().getString(R.string.bo3_3)));
        arrayItem.add(new Item(R.drawable.c5,getResources().getString(R.string.bo4), getResources().getString(R.string.bo4_4)));
        arrayItem.add(new Item(R.drawable.c6,getResources().getString(R.string.bo5), getResources().getString(R.string.bo5_5)));
        arrayItem.add(new Item(R.drawable.c7,getResources().getString(R.string.bo6), getResources().getString(R.string.bo6_6)));
        arrayItem.add(new Item(R.drawable.c8,getResources().getString(R.string.bo7), getResources().getString(R.string.bo7_7)));
        arrayItem.add(new Item(R.drawable.c9,getResources().getString(R.string.bo8), getResources().getString(R.string.bo8_8)));
        arrayItem.add(new Item(R.drawable.c10,getResources().getString(R.string.bo9), getResources().getString(R.string.bo9_9)));
        arrayItem.add(new Item(R.drawable.c11,getResources().getString(R.string.bo10), getResources().getString(R.string.bo10_10)));
        arrayItem.add(new Item(R.drawable.c12,getResources().getString(R.string.bo11), getResources().getString(R.string.bo11_11)));


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






