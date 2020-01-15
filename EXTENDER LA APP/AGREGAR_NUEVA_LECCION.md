# Pasos para Agregar una Nueva Lección

## 1.	Crea una nueva actividad (vista)

Para esto, haz click derecho sobre `app` en el menú en la parte izquierda de **Android Studio**, en el menú que se abre haz click en `New > Activity > Basic Activity`. <br>

<p align="center">
  <img alt="Crear nueva actividad 1" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/CREAR_NUEVA_ACTIVIDAD_1.png">
</p>

Cambia el **Activity Name** por ```<NuevaLeccion>Activity```. Asegúrate que **Package name** diga ```com.educationalappsdev.ticseguro.view``` y luego haz click en **Finish**. <br>

<p align="center">
  <img alt="Crear nueva actividad 2" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/CREAR_NUEVA_ACTIVIDAD_2.png">
</p>

Se van a crear 3 archivos: ```<NuevaLeccion>Activity``` en ```app/java/com/educationalappsdev/ticseguro/view```, ```activity_nombre_nueva_leccion.xml``` en ```app/res/layout``` y ```content_nueva_leccion.xml```. <br>

Si usas un sistema de control de versiones como **Git**, te saldrá una nueva pantalla preguntándote si quieres añadir los nuevos archivos a **Git**. Presiona **Add**.

<p align="center">
  <img alt="Crear nueva actividad 3" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/CREAR_NUEVA_ACTIVIDAD_3.png">
</p>

<br>

## 2.	Edita los archivos creados con el contenido de la nueva lección

Usa como referencia los archivos de la lección **Phishing**: ```PhishingActivity```, ```activity_phishing.xml``` y ```content_phishing.xml```. <br>

Recuerda que **PhishingActivity** (```app/java/com/educationalappsdev/ticseguro/view/PhishingActivity```) es el controlador de la vista ```activity_phishing.xml```, la cual tiene una instrucción XML que incluye el contenido de ```content_phishing.xml```.

<br>

## 3.	Conecta la nueva lección con la aplicación.

### 3.1 Ve a **RecyclerViewLeccionesAdapter**. 

Lo encuentras en ```app/java/com/educationalappsdev/ticseguro/view/RecyclerViewLeccionesAdapter```. <br> 

En el método ```onBindViewHolder``` encontrarás un bloque de instrucciones ```if```. Después del bloque de código 
```java
else if (nextActivity.equals(“Internet”)) { … }
```
añade:

```java
else if (nextActivity.equals(“<Nueva Leccion>”))
{
  nextClass = <NuevaLeccion>Activity.class;
}
```

<p align="center">
  <img alt="Conectar nueva lección 1" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/CONECTAR_NUEVA_LECCION_1.png">
</p>

### 3.2 Ve a **HomeFragment**. 

Lo encuentras en ```app/java/com/educationalappsdev/ticseguro/view/HomeFragment```. En el método ```initImageBitmaps()``` añade dos instrucciones. 

La primera es la URL de la foto de la nueva lección (te recomiendo usar [Pexels](https://www.pexels.com) por que las fotos de **Pexels** son gratis para uso comercial y no se requiere atribución) y el título de la lección.

<p align="center">
  <img alt="Conectar nueva lección 2" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/CONECTAR_NUEVA_LECCION_2.png">
</p>

<br>

## 4.	Prueba que la nueva lección funcione.

Dale click al botón **Run** (triángulo verde rotado 45 grados a la derecha en el menú superior de **Android Studio**), selecciona el dispositivo en el que quieres correr la aplicación (si no aparece ninguno crea uno haciendo click en **Create New Virtual Device**) y espera a que cargue la aplicación. Revisa que la nueva lección aparezca en la lista de lecciones.

<p align="center">
  <img alt="Prueba nueva lección 1" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/PRUEBA_NUEVA_LECCION_1.png" height="500" width="300">
</p>

Haz tap sobre la lección. Te debe aparecer el contenido de ```activity_nueva_leccion.xml``` y ```content_nueva_leccion.xml``` (en la siguiente imagen sólo sale un **Floating Action Button** y el título es **NuevaLeccionActivity** porque no añadí contenido a esos dos archivos y eso es lo que **Android Studio** crea por defecto).

<p align="center">
  <img alt="Prueba lección 2" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/PRUEBA_NUEVA_LECCION_2.png" height="500" width="300">
</p>

Para cambiar el título de la parte superior, ve a ```app/res/values/strings.xml``` y busca el string con nombre ```title_activity_nueva_leccion```. Edita el contenido entre las etiquetas ```<string></string>```

<p align="center">
  <img alt="Prueba lección 3" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/PRUEBA_NUEVA_LECCION_3.png">
</p>

<p align="center">
  <img alt="Prueba lección 4" src="https://raw.githubusercontent.com/JulioPoveda/TICSeguro/master/images/EXTENDER%20LA%20APP/AGREGAR%20LECCIÓN/PRUEBA_NUEVA_LECCION_4.png">
</p>
