package com.japg.ticseguro.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.japg.ticseguro.R;

import static android.content.Context.MODE_PRIVATE;

public class ProfileFragment extends Fragment {

    TextView userNameTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String user = this.getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getString("userName", "usuario");

        userNameTextView = getView().findViewById(R.id.username);
        userNameTextView.setText(user);

    }
}
