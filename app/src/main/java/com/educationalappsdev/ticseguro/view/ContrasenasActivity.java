package com.educationalappsdev.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.educationalappsdev.ticseguro.R;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.1 - Enero 2020
 * ---------------------------------------------------------------------------------------
 *
 * Clase ContrasenasActivity
 *
 * Representa el controlador de la vista activity_contrasenas.xml
 */
public class ContrasenasActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean alreadyVisitedActivity = false;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

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

        checkConnection();

    }

    @Override
    protected void onStart() {
        super.onStart();

        ScrollView scrollView = (ScrollView) findViewById(R.id.contrasenas_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
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
                buildDialogInternetRestablished(ContrasenasActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(ContrasenasActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    //------------------------------------------------------------------------------------
    // Métodos que responden a clicks en botones
    //------------------------------------------------------------------------------------

    public void aprendeMasSobreContrasenas(View view) {

        Intent aprendeMasSobreContrasenasIntent = new Intent(ContrasenasActivity.this, AprendeMasContrasenasActivity.class);
        startActivity(aprendeMasSobreContrasenasIntent);

    }

    public void pruebaTusConocimientosSobreContrasenas(View view) {

        Intent pruebaTusConocimientosSobreContrasenasIntent = new Intent(ContrasenasActivity.this, Pregunta1ContrasenasActivity.class);
        startActivity(pruebaTusConocimientosSobreContrasenasIntent);

    }

}
