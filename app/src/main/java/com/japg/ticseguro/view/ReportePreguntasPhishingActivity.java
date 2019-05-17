package com.japg.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.japg.ticseguro.R;

import pl.droidsonroids.gif.GifImageView;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase ReportePreguntasPhishingActivity
 *
 * Representa el controlador de la vista activity_reporte_preguntas_phishing.xml
 */
public class ReportePreguntasPhishingActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean alreadyVisitedActivity = false;
    int puntos;

    TextView tituloReporte;
    GifImageView gifReporte;
    TextView descripcionReporte;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_preguntas_phishing);
        Toolbar toolbar = findViewById(R.id.reporte_phishing_toolbar);
        setSupportActionBar(toolbar);

        tituloReporte = findViewById(R.id.titulo_reporte_preguntas_phishing);
        gifReporte = findViewById(R.id.gif_reporte_preguntas_phishing);
        descripcionReporte = findViewById(R.id.descripcion_reporte_preguntas_phishing);

        checkConnection();

    }

    @Override
    protected void onStart() {
        super.onStart();

        puntos = getIntent().getExtras().getInt("PUNTOS");

        if (puntos == 3)
        {
            tituloReporte.setText(R.string.titulo_muy_bien);
            gifReporte.setImageResource(R.drawable.muy_bien);
            descripcionReporte.setText(R.string.descripcion_muy_bien_phishing);
        }
        else if (puntos == 2)
        {
            tituloReporte.setText(R.string.titulo_vas_por_buen_camino);
            gifReporte.setImageResource(R.drawable.vas_por_buen_camino);
            descripcionReporte.setText(R.string.descripcion_vas_por_buen_camino_phishing);
        }
        else if (puntos == 1 || puntos == 0)
        {
            tituloReporte.setText(R.string.titulo_sigue_esforzandote);
            gifReporte.setImageResource(R.drawable.sigue_esforzandote);
            descripcionReporte.setText(R.string.descripcion_sigue_esforzandote_phishing);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication.getInstance().setConnectivityListener(this);
    }

    //------------------------------------------------------------------------------------
    // Métodos Conectividad Eventual
    //------------------------------------------------------------------------------------

    public void buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No tienes conexión a Internet");
        builder.setMessage("Algunas de las funcionalidades de la app pueden estar desactivadas. Por favor, conéctate lo más pronto a Internet.");

        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        }).show();

    }

    public void buildDialogInternetRestablished(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("¡Ya tienes conexión a Internet!");
        builder.setMessage("Disfruta de TICSeguro.");

        builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        }).show();

    }

    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showInternetConnectionMessage(isConnected);
    }

    private void showInternetConnectionMessage(boolean isConnected) {

        if (isConnected)
        {
            if (alreadyVisitedActivity)
            {
                buildDialogInternetRestablished(ReportePreguntasPhishingActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(ReportePreguntasPhishingActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    //------------------------------------------------------------------------------------
    // Métodos que responden a clicks en botones
    //------------------------------------------------------------------------------------

    public void seguirAprendiendo(View view) {

        Intent seguirAprendiendoIntent = new Intent(ReportePreguntasPhishingActivity.this, PhishingActivity.class);
        startActivity(seguirAprendiendoIntent);

    }

    public void volverAInicio(View view) {

        Intent volverAInicioIntent = new Intent(ReportePreguntasPhishingActivity.this, MainMenuActivity.class);
        startActivity(volverAInicioIntent);

    }

}
