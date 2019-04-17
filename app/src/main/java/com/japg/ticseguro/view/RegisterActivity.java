package com.japg.ticseguro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.japg.ticseguro.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText apodoEditText;
    private Button registrarseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        apodoEditText = findViewById(R.id.apodoEditText);
        registrarseButton = findViewById(R.id.registrarseButton);

        apodoEditText.addTextChangedListener(registerTextWatcher);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private TextWatcher registerTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String apodoInput = apodoEditText.getText().toString().trim();

            registrarseButton.setEnabled(!apodoInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public void registrateClick(View view) {
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("userRegistered", true).commit();

        String userName = apodoEditText.getText().toString();

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putString("userName", userName).commit();

        Intent mainMenuIntent = new Intent(RegisterActivity.this, MainMenuActivity.class);
        startActivity(mainMenuIntent);
    }

}
