package com.japg.ticseguro.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.japg.ticseguro.R;

import android.content.Intent;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase SplashScreenActivity
 *
 * Representa el controlador de la vista activity_splash_screen.xml
 */
public class SplashScreenActivity extends AppCompatActivity {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private static int SPLASH_TIME_OUT = 4000;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        Boolean userRegistered = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("userRegistered", false);

        if (isFirstRun || !userRegistered)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this, RegistroActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }

}
