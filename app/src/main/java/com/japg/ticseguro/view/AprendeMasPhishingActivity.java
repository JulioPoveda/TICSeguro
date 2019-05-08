package com.japg.ticseguro.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.japg.ticseguro.R;

public class AprendeMasPhishingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprende_mas_phishing);
        Toolbar toolbar = findViewById(R.id.aprende_mas_sobre_phishing_toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        TextView linkPhishing1 = (TextView) findViewById(R.id.link_phishing_1);
        linkPhishing1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkPhishing2 = (TextView) findViewById(R.id.link_phishing_2);
        linkPhishing2.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
