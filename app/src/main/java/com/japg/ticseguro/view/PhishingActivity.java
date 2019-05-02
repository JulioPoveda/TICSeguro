package com.japg.ticseguro.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.japg.ticseguro.R;

public class PhishingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phishing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        VideoView videoView = findViewById(R.id.video_view_phishing);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void aprendeMasSobrePhishingClick(View view)
    {
        System.out.println("CLICKED APRENDE MAS");
        Intent mainMenuIntent = new Intent(PhishingActivity.this, AprendeMasPhishingActivity.class);
        startActivity(mainMenuIntent);
    }

    public void pruebaTusConocimientosPhishingClick(View view)
    {
        System.out.println("CLICKED PRUEBA TUS CONOCIMIENTOS");
        Intent mainMenuIntent = new Intent(PhishingActivity.this, PruebaTusConocimientosPhishingActivity.class);
        startActivity(mainMenuIntent);
    }
}
