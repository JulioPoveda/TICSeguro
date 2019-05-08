package com.japg.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
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

public class AprendeMasRedesSocialesActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    boolean alreadyVisitedActivity = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_redes_sociales);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_redes_sociales_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TextView linkRedesSociales1 = (TextView) findViewById(R.id.link_redes_sociales_1);
        linkRedesSociales1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales2 = (TextView) findViewById(R.id.link_redes_sociales_2);
        linkRedesSociales2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales3 = (TextView) findViewById(R.id.link_redes_sociales_3);
        linkRedesSociales3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales4 = (TextView) findViewById(R.id.link_redes_sociales_4);
        linkRedesSociales4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales5 = (TextView) findViewById(R.id.link_redes_sociales_5);
        linkRedesSociales5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales6 = (TextView) findViewById(R.id.link_redes_sociales_6);
        linkRedesSociales6.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales7 = (TextView) findViewById(R.id.link_redes_sociales_7);
        linkRedesSociales7.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkRedesSociales8 = (TextView) findViewById(R.id.link_redes_sociales_8);
        linkRedesSociales8.setMovementMethod(LinkMovementMethod.getInstance());

        checkConnection();

    }

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
    protected void onResume() {
        super.onResume();

        MyApplication.getInstance().setConnectivityListener(this);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

}
