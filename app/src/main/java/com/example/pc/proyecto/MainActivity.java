package com.example.pc.proyecto;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


    }
    public void siguiente(View view){
        Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
        startActivity(i);

    }
    public void pagina(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.amichi.es"));
        startActivity(intent);
    }




}
