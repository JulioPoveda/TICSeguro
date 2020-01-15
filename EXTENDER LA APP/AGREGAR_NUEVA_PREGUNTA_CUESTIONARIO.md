# Pasos para Agregar una Nueva Pregunta a un Cuestionario

## 1.	Crea una nueva actividad (vista)

Para esto, haz click derecho sobre `app` en el menú en la parte izquierda de **Android Studio**, en el menú que se abre haz click en `New > Activity > Basic Activity`. <br>

<p align="center">
  <img alt="Crear nueva actividad 1" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20PREGUNTA%20A%20UN%20CUESTIONARIO/AGREGAR_PREGUNTA_1.png">
</p>

Cambia el **Activity Name** por ```<Pregunta#Leccion>Activity```. Asegúrate de que **Package name** diga ```com.educationalappsdev.ticseguro.view``` y luego haz click en **Finish**. <br>

<p align="center">
  <img alt="Crear nueva actividad 2" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20PREGUNTA%20A%20UN%20CUESTIONARIO/AGREGAR_PREGUNTA_2.png">
</p>

Se van a crear 3 archivos: ```<Pregunta#Leccion>Activity``` en ```app/java/com/educationalappsdev/ticseguro/view```, ```activity_pregunta#_leccion.xml``` en ```app/res/layout``` y ```content_pregunta#_leccion.xml```. <br>

Si usas un sistema de control de versiones como **Git**, te saldrá una nueva pantalla preguntándote si quieres añadir los nuevos archivos a **Git**. Presiona **Add**.

<p align="center">
  <img alt="Crear nueva actividad 3" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20PREGUNTA%20A%20UN%20CUESTIONARIO/AGREGAR_PREGUNTA_3.png">
</p>

<br>

## 2.	Edita los archivos creados con el contenido de la nueva pregunta

Usa como referencia los archivos de **Pregunta1Phishing**: ```Pregunta1PhishingActivity```, ```activity_pregunta1_phishing.xml``` y ```content_pregunta1_phishing.xml```. <br>

Recuerda que **Pregunta1PhishingActivity** (```app/java/com/educationalappsdev/ticseguro/view/Pregunta1PhishingActivity```) es el controlador de la vista ```activity_pregunta1_phishing.xml```, la cual tiene una instrucción XML que incluye el contenido de ```content_pregunta1_phishing.xml```.

<br>

## 3.	Actualiza el progreso unitario de la lección

***Importante*** <br>
*Cuando se agrega un nuevo enlace a **Aprende Más** o una nueva pregunta a **Prueba tus Conocimientos**, hay que hacer un ajuste para que el progreso de la lección se calcule correctamente y se muestre en **Mi Perfil**.*

El **progreso unitario** de cada lección se calcula dividiendo 100 por el número de enlaces (**Aprende Más**) y preguntas (**Prueba tus Conocimientos**) de una lección. Por ejemplo, la lección Phishing tiene dos enlaces en **Aprende Más** y 3 preguntas en **Prueba tus Conocimientos**, por lo que se divide 100 entre 5. 

El **progreso unitario** de la lección Phishing es 20. Esto significa que por cada enlace visitado en **Aprende Más Phishing** y por cada pregunta resuelta en **Prueba tus Conocimientos**, se añade 20% al progreso del usuario en la lección Phishing.

Con la nueva pregunta, tienes que calcular de nuevo el **progreso unitario** de la lección donde vas a poner la pregunta, y actualizar el **progreso unitario** que se suma al progreso de esa lección cuando el usuario visita un enlace en **Aprende Más** y responde una pregunta en **Prueba tus Conocimientos**. 

Por ejemplo, si vas a añadir una nueva pregunta para la lección Phishing, tienes que hacer ajustes en:

* ```AprendeMasPhishingActivity.java```
* ```Pregunta1PhishingActivity.java```
* ```Pregunta2PhishingActivity.java```
* ```Pregunta3PhishingActivity.java```
* ```ReportePreguntasPhishingActivity.java```

En ```AprendeMasPhishingActivity.java```, ```Pregunta1PhishingActivity.java```, ```Pregunta2PhishingActivity.java``` y ```Pregunta3PhishingActivity.java``` hay una constante que se llama **PROGRESO_UNITARIO_PHISHING**. 

Si añades una nueva pregunta, el **progreso unitario** de la lección Phishing dejará de ser 20 y se convertiría en 16 (100 / 6), por lo que tienes que cambiar el valor de la constante **PROGRESO_UNITARIO_PHISHING** de 20 a 16.

En ```ReportePreguntasPhishingActivity.java``` hay un bloque de instrucciones `if` en el método `onStart()` que, dependiendo de las preguntas correctas del usuario, le muestran los mensajes *¡Muy Bien!*, *¡Vas por buen camino!* o *¡Sigue esforzándote!*. 

Al añadir una nueva pregunta, el mensaje *¡Muy Bien!* debería salir cuando el usuario tenga 4 puntos, y el mensaje *¡Vas por buen camino!* saldría cuando el usuario tiene 3 o 2 puntos. Esto tienes que actualizarlo.

## 3.	Conecta la nueva pregunta con el cuestionario correspondiente

Luego de actualizar el progreso de la lección, conecta la nueva pregunta con el cuestionario (puedes agregarla en la posición que quieras, lo importante es que actualices qué pasa cuando se presiona el botón **Siguiente Pregunta** en la vista de una pregunta). 

Es importante resaltar que cada pregunta es un **Activity**, y que para pasar de un **Activity** a otro se usan **Intents**. Los **Intents** en **Prueba tus Conocimientos** se llaman en los métodos que responden a taps en botones. 

Por ejemplo, en ```Pregunta1PhishingActivity.java``` hay un método que se llama `continuar(View view)`, este método se ejecuta cuando el usuario hace tap en el botón **Siguiente Pregunta** de la vista **Pregunta 1 Phishing**(`app/res/layout/activity_pregunta1_phishing.xml`). 

Al final de ese método hay unas instrucciones que crean un **Intent** desde ```Pregunta1PhishingActivity``` hasta ```Pregunta2PhishingActivity```, le agregan un “Extra” que es el número de puntos del usuario, e inician la nueva actividad:

<p align="center">
  <img alt="Uso de intents para conectar la nueva pregunta con el cuestionario" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20PREGUNTA%20A%20UN%20CUESTIONARIO/AGREGAR_PREGUNTA_4.png">
</p>
