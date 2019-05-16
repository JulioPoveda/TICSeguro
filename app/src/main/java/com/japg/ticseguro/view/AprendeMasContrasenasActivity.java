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
 * Clase AprendeMasContrasenasActivity
 *
 * Representa el controlador de la vista activity_aprende_mas_contrasenas.xml
 */
public class AprendeMasContrasenasActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean linkContrasenas1YaFueAbierto;
    boolean linkContrasenas2YaFueAbierto;
    boolean alreadyVisitedActivity = false;

    TextView linkContrasenas1;
    TextView linkContrasenas2;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_contrasenas);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_contrasenas_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        linkContrasenas1 = (TextView) findViewById(R.id.link_contrasenas_1);
        linkContrasenas2 = (TextView) findViewById(R.id.link_contrasenas_2);

        linkContrasenas1YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkContrasenas1YaFueAbierto", false);
        linkContrasenas2YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkContrasenas2YaFueAbierto", false);

        checkConnection();

    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApplication.getInstance().setConnectivityListener(this);
    }

    //------------------------------------------------------------------------------------
    // Métodos
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
                buildDialogInternetRestablished(AprendeMasContrasenasActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(AprendeMasContrasenasActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    public void irALinkContrasenas1(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkContrasenas1YaFueAbierto)
        {
            preferences.edit().putBoolean("linkContrasenas1YaFueAbierto", true).commit();

            int progresoLeccionContrasenasHastaElMomento = preferences.getInt("progresoLeccionContrasenas", 0);
            int nuevoProgresoLeccionContrasenas = progresoLeccionContrasenasHastaElMomento + 20;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionContrasenas", nuevoProgresoLeccionContrasenas).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_contrasenas_1));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkContrasenas2(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkContrasenas2YaFueAbierto)
        {
            preferences.edit().putBoolean("linkContrasenas2YaFueAbierto", true).commit();

            int progresoLeccionContrasenasHastaElMomento = preferences.getInt("progresoLeccionContrasenas", 0);
            int nuevoProgresoLeccionContrasenas = progresoLeccionContrasenasHastaElMomento + 20;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionContrasenas", nuevoProgresoLeccionContrasenas).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_contrasenas_2));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
