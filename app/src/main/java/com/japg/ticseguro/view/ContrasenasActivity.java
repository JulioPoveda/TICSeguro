package com.japg.ticseguro.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.japg.ticseguro.R;

public class ContrasenasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenas);

        ScrollView scrollView = (ScrollView) findViewById(R.id.contrasenas_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        Toolbar toolbar = findViewById(R.id.contrasenas_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        VideoView videoView = findViewById(R.id.video_view_contrasenas);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.contrasenas;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

    @Override
    protected void onStart() {
        super.onStart();

        ScrollView scrollView = (ScrollView) findViewById(R.id.contrasenas_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }

    public void aprendeMasSobreContrasenas(View view) {

        Intent aprendeMasSobreContrasenasIntent = new Intent(ContrasenasActivity.this, AprendeMasContrasenasActivity.class);
        startActivity(aprendeMasSobreContrasenasIntent);

    }

    public void pruebaTusConocimientosSobreContrasenas(View view) {

        Intent pruebaTusConocimientosSobreContrasenasIntent = new Intent(ContrasenasActivity.this, PruebaTusConocimientosContrasenasActivity.class);
        startActivity(pruebaTusConocimientosSobreContrasenasIntent);

    }

}
