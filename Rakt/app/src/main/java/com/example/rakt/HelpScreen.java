package com.example.rakt;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class HelpScreen extends Fragment {

    View view;
    ImageView back_arrow_image;
    TextView how_to_donate_blood,how_to_request_blood;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_help_screen, container, false);

        FindIds();

        OnClicks();

        return view;
    }

    private void FindIds() {

        how_to_donate_blood=view.findViewById(R.id.question1);
        how_to_request_blood=view.findViewById(R.id.question2);
        back_arrow_image=view.findViewById(R.id.image_back);

    }

    private void OnClicks() {

        how_to_donate_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog upload_box=new Dialog(getContext());
                upload_box.setContentView(R.layout.how_to_donate_blood_dialogue_box);
//                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                upload_box.setCanceledOnTouchOutside(false);
                Window window=upload_box.getWindow();
                window.setGravity(Gravity.CENTER);
                upload_box.show();

                upload_box.findViewById(R.id.got_it_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        upload_box.dismiss();

                    }
                });

            }
        });

        how_to_request_blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog upload_box=new Dialog(getContext());
                upload_box.setContentView(R.layout.how_to_request_blood_dialogue_box);
//                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                upload_box.setCanceledOnTouchOutside(false);
                Window window=upload_box.getWindow();
                window.setGravity(Gravity.CENTER);
                upload_box.show();

                upload_box.findViewById(R.id.got_it_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        upload_box.dismiss();

                    }
                });

            }
        });

        back_arrow_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

    }
}