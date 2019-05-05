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

public class TipsFragment extends Fragment {

    private ArrayList<String> tipsNames = new ArrayList<>();
    private ArrayList<String> tipsCategories = new ArrayList<>();
    private ArrayList<String> tipsContent = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initTips();

        View view = inflater.inflate(R.layout.fragment_tips, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_tips);
        RecyclerViewTipsAdapter adapter = new RecyclerViewTipsAdapter(view.getContext(), tipsNames, tipsCategories, tipsContent);
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

    private void initTips()
    {
        tipsNames.add("Tip 1");
        tipsNames.add("Tip 2");
        tipsNames.add("Tip 3");

        tipsCategories.add("Phishing");
        tipsCategories.add("Redes Sociales");
        tipsCategories.add("Internet");

        tipsContent.add("Siempre revisa quién es el emisor del correo.");
        tipsContent.add("No añadas como amigos personas que no conoces.");
        tipsContent.add("Siempre revisa que la página web que estás visitando tenga un candado verde en la parte superior.");
    }
}
