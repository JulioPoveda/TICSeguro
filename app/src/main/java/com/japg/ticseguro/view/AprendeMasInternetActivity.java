package com.japg.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
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
 * Clase AprendeMasInternetActivity
 *
 * Representa el controlador de la vista activity_aprende_mas_internet.xml
 */
public class AprendeMasInternetActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean linkInternet1YaFueAbierto;
    boolean alreadyVisitedActivity = false;

    TextView linkInternet1;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_internet);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_internet_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        linkInternet1 = (TextView) findViewById(R.id.link_internet_1);

        linkInternet1YaFueAbierto = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("linkInternet1YaFueAbierto", false);

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
                buildDialogInternetRestablished(AprendeMasInternetActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(AprendeMasInternetActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    //------------------------------------------------------------------------------------
    // Métodos que responden a clicks en enlaces
    //------------------------------------------------------------------------------------

    public void irALinkInternet1(View view)
    {
        SharedPreferences preferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!linkInternet1YaFueAbierto)
        {
            preferences.edit().putBoolean("linkInternet1YaFueAbierto", true).commit();

            int progresoLeccionInternetHastaElMomento = preferences.getInt("progresoLeccionInternet", 0);
            int nuevoProgresoLeccionInternet = progresoLeccionInternetHastaElMomento + 25;

            // Aumentar progreso
            preferences.edit().putInt("progresoLeccionInternet", nuevoProgresoLeccionInternet).commit();

        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_internet_1));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
