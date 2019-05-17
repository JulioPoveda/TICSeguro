package com.japg.ticseguro.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.japg.ticseguro.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static android.content.Context.MODE_PRIVATE;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase ProfileFragment
 *
 * Representa el controlador de la vista fragment_profile.xml
 */
public class ProfileFragment extends Fragment {

    //------------------------------------------------------------------------------------
    // Constantes
    //------------------------------------------------------------------------------------

    public static final int PICK_IMAGE = 1;

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    TextView userNameTextView;
    ImageView userAvatar;
    Uri selectedImageUri;
    ProgressBar leccionPhishingProgressBar;
    ProgressBar leccionRedesSocialesProgressBar;
    ProgressBar leccionInternetProgressBar;
    ProgressBar leccionContrasenasProgressBar;

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        userAvatar = getView().findViewById(R.id.user_avatar);

        SharedPreferences preferences = getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String imageS = preferences.getString("userAvatar", "");
        Bitmap imageB;
        if(!imageS.equals("")) {
            imageB = decodeToBase64(imageS);
            userAvatar.setImageBitmap(imageB);
        }

        userAvatar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen"), PICK_IMAGE);
            }

        });

        int progresoLeccionPhishing = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE).getInt("progresoLeccionPhishing", 0);
        int progresoLeccionRedesSociales = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE).getInt("progresoLeccionRedesSociales", 0);
        int progresoLeccionInternet = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE).getInt("progresoLeccionInternet", 0);
        int progresoLeccionContrasenas = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE).getInt("progresoLeccionContrasenas", 0);

        System.out.println("PROGRESO " + progresoLeccionPhishing);

        leccionPhishingProgressBar = getActivity().findViewById(R.id.determinateBarPhishing);
        leccionRedesSocialesProgressBar = getActivity().findViewById(R.id.determinateBarRedesSociales);
        leccionInternetProgressBar = getActivity().findViewById(R.id.determinateBarInternet);
        leccionContrasenasProgressBar = getActivity().findViewById(R.id.determinateBarContrasenas);

        leccionPhishingProgressBar.setProgress(progresoLeccionPhishing);
        leccionRedesSocialesProgressBar.setProgress(progresoLeccionRedesSociales);
        leccionInternetProgressBar.setProgress(progresoLeccionInternet);
        leccionContrasenasProgressBar.setProgress(progresoLeccionContrasenas);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String user = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("userName", "usuario");

        userNameTextView = getView().findViewById(R.id.username);
        userNameTextView.setText(user);

        ScrollView scrollView = (ScrollView) getView().findViewById(R.id.profile_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE)
        {

            selectedImageUri = data.getData();

            try
            {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                userAvatar.setImageBitmap(bitmap);

                SharedPreferences preferences = getActivity().getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("userAvatar", encodeToBase64(bitmap));
                //editor.putBoolean("userAvatarChanged", true);
                editor.commit();

            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    public static String encodeToBase64(Bitmap image) {
        Bitmap immage = image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immage.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);

        return imageEncoded;
    }

    public static Bitmap decodeToBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

}
