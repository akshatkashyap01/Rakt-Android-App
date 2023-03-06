package com.example.rakt;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rakt.DonorInformation.DonorInformation;


public class DonorScreen extends Fragment {

   View view;
   ImageView back_arrow,img_donor;
   TextView txt_person_name,txt_person_phone,txt_person_gender,gender;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_donor_screen, container, false);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FindIds();

        OnClicks();


        DonorInformation donorInformation=(DonorInformation)getArguments().get("key");


        if(!donorInformation.getImage().equals("no image"))
        {

            img_donor.setImageURI(Uri.parse(donorInformation.getImage()));

        }


        txt_person_name.setText(donorInformation.getName());
        txt_person_phone.setText(donorInformation.getPhone());
        txt_person_gender.setText(donorInformation.getCity());
        gender.setText(donorInformation.getGender());



    }

    private void FindIds() {

        back_arrow=view.findViewById(R.id.image_back);
        img_donor=view.findViewById(R.id.img_donor);
        txt_person_name=view.findViewById(R.id.txt_person_name);
        txt_person_phone=view.findViewById(R.id.txt_person_phone);
        txt_person_gender=view.findViewById(R.id.txt_person_gender);
        gender=view.findViewById(R.id.gender);



    }

    private void OnClicks() {

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

    }
}