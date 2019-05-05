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

public class PhishingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phishing);

        ScrollView scrollView = (ScrollView) findViewById(R.id.phishing_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        Toolbar toolbar =
                (Toolbar) findViewById(R.id.phishing_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        VideoView videoView = findViewById(R.id.video_view_phishing);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.phishing;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    public void aprendeMasSobrePhishing(View view) {

        Intent aprendeMasSobrePhishingIntent = new Intent(PhishingActivity.this, AprendeMasPhishingActivity.class);
        startActivity(aprendeMasSobrePhishingIntent);

    }

    public void pruebaTusConocimientosSobrePhishing(View view) {

        Intent pruebaTusConocimientosSobrePhishingIntent = new Intent(PhishingActivity.this, PruebaTusConocimientosPhishingActivity.class);
        startActivity(pruebaTusConocimientosSobrePhishingIntent);

    }
}
