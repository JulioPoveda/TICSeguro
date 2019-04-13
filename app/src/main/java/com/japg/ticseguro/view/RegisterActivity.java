package com.japg.ticseguro.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.japg.ticseguro.R;

import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goHome(View view) {
        //Intent intent = new Intent(this, MainMenuActivity.class);
        //startActivity(intent);
    }
}
