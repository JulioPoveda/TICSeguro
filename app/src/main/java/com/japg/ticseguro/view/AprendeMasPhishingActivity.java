package com.japg.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.japg.ticseguro.R;

public class AprendeMasPhishingActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    boolean alreadyVisitedActivity = false;

    TextView linkPhishing1;
    TextView linkPhishing2;
    int clicksLinkPhishing1 = 0;
    int getClicksLinkPhishing2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_phishing);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_phishing_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        linkPhishing1 = (TextView) findViewById(R.id.link_phishing_1);
        linkPhishing2 = (TextView) findViewById(R.id.link_phishing_2);

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
                buildDialogInternetRestablished(AprendeMasPhishingActivity.this);
            }

            alreadyVisitedActivity = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            alreadyVisitedActivity = true;

            buildDialog(AprendeMasPhishingActivity.this);
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

    public void irALinkPhishing1(View view)
    {
        clicksLinkPhishing1 = clicksLinkPhishing1 + 1;

        if (clicksLinkPhishing1 == 1)
        {
            // Aumentar progreso
        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_phishing_1));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void irALinkPhishing2(View view)
    {
        clicksLinkPhishing1 = clicksLinkPhishing1 + 1;

        if (clicksLinkPhishing1 == 1)
        {
            // Aumentar progreso
        }

        Uri uri = Uri.parse(getResources().getString(R.string.link_phishing_2));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
