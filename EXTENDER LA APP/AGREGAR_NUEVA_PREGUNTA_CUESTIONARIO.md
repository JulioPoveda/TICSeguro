# Pasos para Agregar una Nueva Pregunta a un Cuestionario

## 1.	Crea una nueva actividad (vista)

Para esto, haz click derecho sobre app en el menú en la parte izquierda de **Android Studio**, en el menú que se abre haz click en `New > Activity > Basic Activity`. <br>

<p align="center">
  <img alt="Crear nueva actividad 1" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/CREAR_NUEVA_ACTIVIDAD_1.png">
</p>

Cambia el **Activity Name** por ```<NuevaLeccion>Activity```. Asegúrate que **Package name** diga ```com.japg.ticseguro.view``` y luego haz click en **Finish**. <br>

<p align="center">
  <img alt="Crear nueva actividad 2" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/CREAR_NUEVA_ACTIVIDAD_2.png">
</p>

Se van a crear 3 archivos: ```<NuevaLeccion>Activity``` en ```app/java/com/japg/ticseguro/view```, ```activity_<nombre_nueva_leccion.xml``` en ```app/res/layout``` y ```content_nueva_leccion.xml```. <br>

Si usas un sistema de control de versiones como **Git**, te saldrá una nueva pantalla preguntándote si quieres añadir los nuevos archivos a **Git**. Presiona **Add**.

<p align="center">
  <img alt="Crear nueva actividad 3" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/CREAR_NUEVA_ACTIVIDAD_3.png">
</p>

<br>

## 2.	Edita los archivos creados con el contenido de la nueva pregunta

Usa como referencia los archivos de la lección **Phishing**: ```PhishingActivity```, ```activity_phishing.xml``` y ```content_phishing.xml```. <br>

Recuerda que **PhishingActivity** (```app/java/com/japg/ticseguro/view/PhishingActivity```) es el controlador de la vista ```activity_phishing.xml```, la cual tiene una instrucción XML que incluye el contenido de ```content_phishing.xml```.

<br>

## 3.	Conecta la nueva pregunta con el cuestionario correspondiente


