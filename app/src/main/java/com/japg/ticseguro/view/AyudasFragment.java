package com.japg.ticseguro.view;

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

import com.japg.ticseguro.R;

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

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private int[] images = {R.drawable.phishing, R.drawable.redes_sociales, R.drawable.internet, R.drawable.contrasenas};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initImageBitmaps();

        View view = inflater.inflate(R.layout.fragment_ayudas, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_ayudas);
        RecyclerViewAyudasAdapter adapter = new RecyclerViewAyudasAdapter(view.getContext(), mNames, mImageUrls, images);
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

    private void initImageBitmaps() {

        mImageUrls.add("https://caivirtual.policia.gov.co/sites/all/themes/ccp/logo.png");
        mNames.add("Centro Cibernético Policial");

        mImageUrls.add("http://www.sic.gov.co/sites/all/themes/SIC2016/logo.png");
        mNames.add("Superintendencia de Industria y Comercio");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/c/c2/MinTIC_%28Colombia%29_logo.png");
        mNames.add("MinTIC");
    }
}
