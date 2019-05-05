package com.japg.ticseguro.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.japg.ticseguro.R;

public class RedesSocialesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);

        ScrollView scrollView = (ScrollView) findViewById(R.id.redes_sociales_scrollview);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        Toolbar toolbar =
                (Toolbar) findViewById(R.id.redes_sociales_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        VideoView videoView = findViewById(R.id.video_view_redes_sociales);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.redes_sociales;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

    public void aprendeMasSobreRedesSociales(View view) {

        Intent aprendeMasIntent = new Intent(RedesSocialesActivity.this, AprendeMasRedesSocialesActivity.class);
        startActivity(aprendeMasIntent);

    }


    public void pruebaTusConocimientosSobreRedesSociales(View view) {

        Intent pruebaTusConocimientosIntent = new Intent(RedesSocialesActivity.this, PruebaTusConocimientosRedesSocialesActivity.class);
        startActivity(pruebaTusConocimientosIntent);

    }

}
