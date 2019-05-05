package com.japg.ticseguro.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.japg.ticseguro.R;

public class InternetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ScrollView scrollView = (ScrollView) findViewById(R.id.internet_scroll_view);
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
    }

}
