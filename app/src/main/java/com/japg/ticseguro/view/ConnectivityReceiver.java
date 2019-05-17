package com.japg.ticseguro.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase ConnectivityReceiver
 *
 * Se requiere para determinar si hay cambios en la conectividad del usuario
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    public static ConnectivityReceiverListener connectivityReceiverListener;

    //------------------------------------------------------------------------------------
    // Constructores
    //------------------------------------------------------------------------------------

    public ConnectivityReceiver() {
        super();
    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public static boolean isConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) MyApplication.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}
