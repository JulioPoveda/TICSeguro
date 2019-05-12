package com.japg.ticseguro.view;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.japg.ticseguro.R;

public class Pregunta3ContrasenasActivity extends AppCompatActivity {

    boolean alreadyVisitedActivity = false;

    Button botonOpcion1;
    Button botonOpcion2;
    Button botonOpcion3;
    Button botonOpcion4;

    int numeroDeVecesBoton1Presionado = 2;
    int numeroDeVecesBoton2Presionado = 2;
    int numeroDeVecesBoton3Presionado = 2;
    int numeroDeVecesBoton4Presionado = 2;

    private SensorManager sm;

    private float currentAcceleration;

    private float lastAcceleration;

    private float shake;

    TextView tituloRespuesta;
    TextView respuestaPregunta3;
    Button botonContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3_contrasenas);
        Toolbar toolbar = findViewById(R.id.pregunta3_contrasenas_toolbar);
        setSupportActionBar(toolbar);


    }

}
