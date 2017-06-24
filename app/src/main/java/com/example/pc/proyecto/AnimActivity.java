package com.example.pc.proyecto;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimActivity extends AppCompatActivity {

    private ImageView ivLogo;
    private ImageView ivLogo1;
    private Animation animacion;
    private Animation animacion1;
    private Animation animacion2;
    MediaPlayer mus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_anim);
        //mus=MediaPlayer.create(this,R.raw.musica);
       // mus.start();

        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        ivLogo1 = (ImageView) findViewById(R.id.ivLogo1);
        animacion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.des);
        animacion1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.apa);
        animacion2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tras);

        ivLogo1.startAnimation(animacion);
        ivLogo.startAnimation(animacion1);
        ivLogo.startAnimation(animacion2);





        animacion.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
