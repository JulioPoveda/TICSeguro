package com.educationalappsdev.ticseguro.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.educationalappsdev.ticseguro.R;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.1 - Enero 2020
 * ---------------------------------------------------------------------------------------
 *
 * Clase Pregunta1ContrasenasActivity
 *
 * Representa el controlador de la vista activity_pregunta1_contrasenas.xml
 */
public class Pregunta1ContrasenasActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    //------------------------------------------------------------------------------------
    // Constantes
    //------------------------------------------------------------------------------------

    final private static int PROGRESO_UNITARIO_CONTRASENAS = 20;

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    boolean preguntaCorrecta;
    boolean yaVioRespuesta;
    boolean elBotonSiguientePreguntaYaFuePresionado;
    boolean yaVisitoActividad = false;

    int numeroDeVecesBoton1Presionado = 2;
    int numeroDeVecesBoton2Presionado = 2;
    int numeroDeVecesBoton3Presionado = 2;
    int numeroDeVecesBoton4Presionado = 2;
    int puntos;

    private SensorManager sm;
    private float currentAcceleration;
    private float lastAcceleration;
    private float shake;

    Button botonOpcion1;
    Button botonOpcion2;
    Button botonOpcion3;
    Button botonOpcion4;

    TextView tituloRespuesta;
    TextView respuestaPregunta1;
    Button botonContinuar;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1_contrasenas);
        Toolbar toolbar = findViewById(R.id.prueba_tus_conocimientos_sobre_contrasenas_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        checkConnection();

        botonOpcion1 = findViewById(R.id.contrasenas_pregunta_1_opcion_1);
        botonOpcion2 = findViewById(R.id.contrasenas_pregunta_1_opcion_2);
        botonOpcion3 = findViewById(R.id.contrasenas_pregunta_1_opcion_3);
        botonOpcion4 = findViewById(R.id.contrasenas_pregunta_1_opcion_4);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        currentAcceleration = SensorManager.GRAVITY_EARTH;
        lastAcceleration = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

        tituloRespuesta = findViewById(R.id.titulo_respuesta);
        respuestaPregunta1 = findViewById(R.id.contrasenas_pregunta_1_respuesta);
        botonContinuar = findViewById(R.id.boton_pregunta_1_continuar_contrasenas);

        elBotonSiguientePreguntaYaFuePresionado = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("contrasenasPregunta1BotonSiguientePreguntaYaFuePresionado", false);

    }

    @Override
    protected void onStart() {
        super.onStart();

        puntos = 0;
        preguntaCorrecta = false;
        yaVioRespuesta = false;

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
            if (yaVisitoActividad)
            {
                buildDialogInternetRestablished(Pregunta1ContrasenasActivity.this);
            }

            yaVisitoActividad = true;
        }
        else
        {
            // Se necesita para que se muestre el mensaje de reconexión si el usuario abrió la app sin conexión a Internet
            yaVisitoActividad = true;

            buildDialog(Pregunta1ContrasenasActivity.this);
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetConnectionMessage(isConnected);
    }

    //------------------------------------------------------------------------------------
    // Métodos que responden a clicks en botones
    //------------------------------------------------------------------------------------

    public void seleccionarOpcion1(View view)
    {
        if (numeroDeVecesBoton1Presionado % 2 == 0)
        {
            botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton1Presionado = 3;
            numeroDeVecesBoton2Presionado = 2;
            numeroDeVecesBoton3Presionado = 2;
            numeroDeVecesBoton4Presionado = 2;
        }
        else
        {
            botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton1Presionado = 2;
        }

        tituloRespuesta.setVisibility(View.INVISIBLE);
        respuestaPregunta1.setVisibility(View.INVISIBLE);
        botonContinuar.setVisibility(View.INVISIBLE);

    }

    public void seleccionarOpcion2(View view)
    {
        if (numeroDeVecesBoton2Presionado % 2 == 0)
        {
            botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton2Presionado = 3;
            numeroDeVecesBoton1Presionado = 2;
            numeroDeVecesBoton3Presionado = 2;
            numeroDeVecesBoton4Presionado = 2;
        }
        else
        {
            botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton2Presionado = 2;
        }

        tituloRespuesta.setVisibility(View.INVISIBLE);
        respuestaPregunta1.setVisibility(View.INVISIBLE);
        botonContinuar.setVisibility(View.INVISIBLE);

    }

    public void seleccionarOpcion3(View view)
    {
        if (numeroDeVecesBoton3Presionado % 2 == 0)
        {
            botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton3Presionado = 3;
            numeroDeVecesBoton1Presionado = 2;
            numeroDeVecesBoton2Presionado = 2;
            numeroDeVecesBoton4Presionado = 2;
        }
        else
        {
            botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton3Presionado = 2;
        }

        tituloRespuesta.setVisibility(View.INVISIBLE);
        respuestaPregunta1.setVisibility(View.INVISIBLE);
        botonContinuar.setVisibility(View.INVISIBLE);

    }

    public void seleccionarOpcion4(View view)
    {
        if (numeroDeVecesBoton4Presionado % 2 == 0)
        {
            botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton4Presionado = 3;
            numeroDeVecesBoton1Presionado = 2;
            numeroDeVecesBoton2Presionado = 2;
            numeroDeVecesBoton3Presionado = 2;
        }
        else
        {
            botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
            numeroDeVecesBoton4Presionado = 2;
        }

        tituloRespuesta.setVisibility(View.INVISIBLE);
        respuestaPregunta1.setVisibility(View.INVISIBLE);
        botonContinuar.setVisibility(View.INVISIBLE);

    }

    public void continuar(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);

        if (!elBotonSiguientePreguntaYaFuePresionado)
        {
            sharedPreferences.edit().putBoolean("contrasenasPregunta1BotonSiguientePreguntaYaFuePresionado", true).commit();

            int progresoLeccionContrasenasHastaElMomento = sharedPreferences.getInt("progresoLeccionContrasenas", 0);
            int nuevoProgresoLeccionContrasenas = progresoLeccionContrasenasHastaElMomento + PROGRESO_UNITARIO_CONTRASENAS;

            // Aumentar progreso
            sharedPreferences.edit().putInt("progresoLeccionContrasenas", nuevoProgresoLeccionContrasenas).commit();
        }

        Intent pregunta2ContrasenasIntent = new Intent(Pregunta1ContrasenasActivity.this, Pregunta2ContrasenasActivity.class);
        pregunta2ContrasenasIntent.putExtra("PUNTOS", puntos);
        startActivity(pregunta2ContrasenasIntent);
    }

    //------------------------------------------------------------------------------------
    // Sensor Event Listener
    //------------------------------------------------------------------------------------

    private final SensorEventListener sensorListener = new SensorEventListener()
    {

        @Override
        public void onSensorChanged(SensorEvent event) {

            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            lastAcceleration = currentAcceleration;
            currentAcceleration = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = currentAcceleration - lastAcceleration;
            shake = shake * 0.9f + delta;

            if (shake > 12)
            {
                boolean condicion1 = numeroDeVecesBoton4Presionado == 3;

                if (condicion1 && !yaVioRespuesta)
                {
                    yaVioRespuesta = true;
                    preguntaCorrecta = true;
                    puntos = puntos + 1;
                }

                botonOpcion4.setBackgroundColor(getResources().getColor(R.color.colorOpcionCorrecta));
                botonOpcion1.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
                botonOpcion2.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));
                botonOpcion3.setBackgroundColor(getResources().getColor(R.color.colorTarjetaModuloAprendizaje));

                tituloRespuesta.setVisibility(View.VISIBLE);
                respuestaPregunta1.setVisibility(View.VISIBLE);
                botonContinuar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}
