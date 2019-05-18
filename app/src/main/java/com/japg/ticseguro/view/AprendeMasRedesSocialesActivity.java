package com.japg.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.japg.ticseguro.R;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase AprendeMasRedesSocialesActivity
 *
 * Representa el controlador de la vista activity_aprende_mas_redes_sociales.xml
 */
public class AprendeMasRedesSocialesActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Constantes
    //------------------------------------------------------------------------------------

    final private static int PROGRESO_UNITARIO_REDES_SOCIALES = 9;

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean linkRedesSociales1YaFueAbierto;
    boolean linkRedesSociales2YaFueAbierto;
    boolean linkRedesSociales3YaFueAbierto;
    boolean linkRedesSociales4YaFueAbierto;
    boolean linkRedesSociales5YaFueAbierto;
    boolean linkRedesSociales6YaFueAbierto;
    boolean linkRedesSociales7YaFueAbierto;
    boolean linkRedesSociales8YaFueAbierto;
    boolean alreadyVisitedActivity = false;

    TextView linkRedesSociales1;
    TextView linkRedesSociales2;
    TextView linkRedesSociales3;
    TextView linkRedesSociales4;
    TextView linkRedesSociales5;
    TextView linkRedesSociales6;
    TextView linkRedesSociales7;
    TextView linkRedesSociales8;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_redes_sociales);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_redes_sociales_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        linkRedesSociales1 = (TextView) findViewById(R.id.link_redes_sociales_1);
        linkRedesSociales2 = (TextView) findViewById(R.id.link_redes_sociales_2);
        linkRedesSociales3 = (TextView) findViewById(R.id.link_redes_sociales_3);
        linkRedesSociales4 = (TextView) findViewById(R.id.link_redes_sociales_4);
        linkRedesSociales5 = (TextView) findViewById(R.id.link_redes_sociales_5);
        linkRedesSociales6 = (TextView) findViewById(R.id.link_redes_sociales_6);
        linkRedesSociales7 = (TextView) findViewById(R.id.link_redes_sociales_7);
        linkRedesSociales8 = (TextView) findViewById(R.id.link_redes_sociales_8);

        linkRedesSociales1YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales1YaFueAbierto", false);
        linkRedesSociales2YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales2YaFueAbierto", false);
        linkRedesSociales3YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales3YaFueAbierto", false);
        linkRedesSociales4YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales4YaFueAbierto", false);
        linkRedesSociales5YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales5YaFueAbierto", false);
        linkRedesSociales6YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales6YaFueAbierto", false);
        linkRedesSociales7YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales7YaFueAbierto", false);
        linkRedesSociales8YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkRedesSociales8YaFueAbierto", false);

        checkConnection();

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
                buildDialogInternetRestablished(AprendeMasRedesSocialesActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(AprendeMasRedesSocialesActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    //------------------------------------------------------------------------------------
    // Métodos que responden a clicks en enlaces
    //------------------------------------------------------------------------------------

    public void irALinkRedesSociales1(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales1YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales1YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_1));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales2(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales2YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales2YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_2));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales3(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales3YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales3YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_3));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales4(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales4YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales4YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_4));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales5(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales5YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales5YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_5));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales6(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales6YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales6YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_6));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales7(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales7YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales7YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_7));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkRedesSociales8(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkRedesSociales8YaFueAbierto)
        {
            preferences.edit().putBoolean("linkRedesSociales8YaFueAbierto", true).commit();

            int progresoLeccionRedesSocialesHastaElMomento = preferences.getInt("progresoLeccionRedesSociales", 0);
            int nuevoProgresoLeccionRedesSociales = progresoLeccionRedesSocialesHastaElMomento + PROGRESO_UNITARIO_REDES_SOCIALES;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionRedesSociales", nuevoProgresoLeccionRedesSociales).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_redes_sociales_8));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
