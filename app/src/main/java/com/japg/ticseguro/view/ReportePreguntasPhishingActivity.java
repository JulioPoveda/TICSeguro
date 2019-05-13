package com.japg.ticseguro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.japg.ticseguro.R;

import pl.droidsonroids.gif.GifImageView;

public class ReportePreguntasPhishingActivity extends AppCompatActivity {

    int puntos;

    TextView tituloReporte;
    GifImageView gifReporte;
    TextView descripcionReporte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_preguntas_phishing);
        Toolbar toolbar = findViewById(R.id.reporte_phishing_toolbar);
        setSupportActionBar(toolbar);

        tituloReporte = findViewById(R.id.titulo_reporte_preguntas_phishing);
        gifReporte = findViewById(R.id.gif_reporte_preguntas_phishing);
        descripcionReporte = findViewById(R.id.descripcion_reporte_preguntas_phishing);

    }

    @Override
    protected void onStart() {
        super.onStart();

        puntos = getIntent().getExtras().getInt("PUNTOS");

        System.out.println("LOS PUNTOS EN REPORTE SON " + puntos);

        if (puntos == 3)
        {
            tituloReporte.setText("¡Muy bien!");
            gifReporte.setImageResource(R.drawable.muy_bien);
            descripcionReporte.setText("¡Haz aprendido mucho sobre Phishing!");
        }
        else if (puntos == 2)
        {
            tituloReporte.setText("¡Vas por buen camino!");
            gifReporte.setImageResource(R.drawable.vas_por_buen_camino);
            descripcionReporte.setText("Estás aprendiendiendo mucho sobre Phishing. ¡Sigue así!");
        }
        else if (puntos == 1 || puntos == 0)
        {
            tituloReporte.setText("¡Sigue esforzándote!");
            gifReporte.setImageResource(R.drawable.sigue_esforzandote);
            descripcionReporte.setText("¡No te rindas! Aún hay mucho por aprender y mejorar.");
        }

    }

    public void seguirAprendiendo(View view) {

        Intent seguirAprendiendoIntent = new Intent(ReportePreguntasPhishingActivity.this, PhishingActivity.class);
        startActivity(seguirAprendiendoIntent);

    }

    public void volverAInicio(View view) {

        Intent volverAInicioIntent = new Intent(ReportePreguntasPhishingActivity.this, MainMenuActivity.class);
        startActivity(volverAInicioIntent);

    }

}
