package com.educationalappsdev.ticseguro.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.educationalappsdev.ticseguro.R;

import java.util.ArrayList;

/**
 * ---------------------------------------------------------------------------------------
 * TICSeguro
 * App de Enseñanza de Conceptos de Seguridad Informática para Usuarios Regulares
 * Por Julio Poveda
 * Versión 1.0 - Mayo 2019
 * ---------------------------------------------------------------------------------------
 *
 * Clase AyudasFragment
 *
 * Representa el controlador de la vista fragment_ayudas.xml
 */
public class AyudasFragment extends Fragment {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initImageBitmaps();

        View view = inflater.inflate(R.layout.fragment_ayudas, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_ayudas);
        RecyclerViewAyudasAdapter adapter = new RecyclerViewAyudasAdapter(view.getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScrollView scrollView = (ScrollView) getView().findViewById(R.id.ayudas_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    private void initImageBitmaps() {

        mImageUrls.add("android.resource://com.educationalappsdev.ticseguro/" + R.drawable.centro_cibernetico_policial);
        mNames.add("Centro Cibernético Policial");

        mImageUrls.add("android.resource://com.educationalappsdev.ticseguro/" + R.drawable.superintendencia_de_industria_y_comercio);
        mNames.add("Superintendencia de Industria y Comercio");

        mImageUrls.add("android.resource://com.educationalappsdev.ticseguro/" + R.drawable.mintic);
        mNames.add("MinTIC");
    }
}
