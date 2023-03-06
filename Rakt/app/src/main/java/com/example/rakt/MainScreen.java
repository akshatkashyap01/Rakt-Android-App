package com.example.rakt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class MainScreen extends Fragment {

    View view;
    RelativeLayout DonateBlood_btn;
    RelativeLayout RequestBlood_btn;
    RelativeLayout settings_btn;

    public static final String donor_file="donor_file";
    public static final String donor_key="donor_key";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_screen, container, false);

        FindIds();

        OnClicks();

        return view;
    }

    private void FindIds() {

        DonateBlood_btn = view.findViewById(R.id.tile_donate_blood);
        RequestBlood_btn = view.findViewById(R.id.tile_request_blood);
        settings_btn = view.findViewById(R.id.tile_settings);

    }

    private void OnClicks() {

        DonateBlood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_home_to_donateBloodScreen);

            }
        });

        RequestBlood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_home_to_requestBloodScreen);

            }
        });

        settings_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_home_to_settingsSreenFragment);

            }
        });

        view.findViewById(R.id.tile_blood_bank).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("geo:30.897343,76.408004"));

                Intent chooser = Intent.createChooser(intent,"Launch Maps");

                startActivity(chooser);

            }
        });





    }

    private void onBackButtonPressed() {

    }


}