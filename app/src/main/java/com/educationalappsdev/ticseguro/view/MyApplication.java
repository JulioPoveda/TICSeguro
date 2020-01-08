package com.educationalappsdev.ticseguro.view;

import android.app.Application;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase MyApplication
 *
 * Se requiere para determinar si hay cambios en la conectividad del usuario
 */
public class MyApplication extends Application {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private static MyApplication mInstance;

    //------------------------------------------------------------------------------------
    // Constructores
    //------------------------------------------------------------------------------------

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }

}
