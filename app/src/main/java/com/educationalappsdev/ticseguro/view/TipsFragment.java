package com.educationalappsdev.ticseguro.view;

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
 * Clase TipsFragment
 *
 * Representa el controlador de la vista fragment_tips.xml
 */
public class TipsFragment extends Fragment {

    //------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------

    private ArrayList<String> nombresTips = new ArrayList<>();
    private ArrayList<String> categoriasTips = new ArrayList<>();
    private ArrayList<String> contenidosTips = new ArrayList<>();

    //------------------------------------------------------------------------------------
    // Métodos Ciclo de Vida de la Actividad
    //------------------------------------------------------------------------------------

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initTips();

        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_tips);
        RecyclerViewTipsAdapter adapter = new RecyclerViewTipsAdapter(view.getContext(), nombresTips, categoriasTips, contenidosTips);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScrollView scrollView = (ScrollView) getView().findViewById(R.id.tips_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

    }

    //------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------

    private void initTips()
    {
        nombresTips.add("Tip 1");
        nombresTips.add("Tip 2");
        nombresTips.add("Tip 3");

        categoriasTips.add("Phishing");
        categoriasTips.add("Redes Sociales");
        categoriasTips.add("Internet");

        contenidosTips.add("Siempre revisa quién es el emisor del correo.");
        contenidosTips.add("No añadas como amigos personas que no conoces.");
        contenidosTips.add("Siempre revisa que la página web que estás visitando tenga un candado verde en la parte superior.");
    }

}
