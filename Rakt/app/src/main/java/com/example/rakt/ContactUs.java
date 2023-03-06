package com.example.rakt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class ContactUs extends Fragment {

    View view;
    ImageView back_img;
    Button done_button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact_us, container, false);


        FindIds();

        OnClicks();

        return view;
    }

    private void FindIds() {

        back_img = view.findViewById(R.id.contact_us_image_back);
        done_button = view.findViewById(R.id.done_btn);

    }

    private void OnClicks() {

       back_img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               getActivity().onBackPressed();

           }
       });

    }
}