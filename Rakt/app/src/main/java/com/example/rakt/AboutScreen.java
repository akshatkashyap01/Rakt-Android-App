package com.example.rakt;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AboutScreen extends Fragment {

    View view;
    ImageView back_img;
    TextView contact_us_txt,feedback_txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_screen, container, false);

        FindId();

        OnClicks();

        return view;
    }

    private void FindId() {

        back_img = view.findViewById(R.id.image_back);
        contact_us_txt = view.findViewById(R.id.txt_contact_us);
        feedback_txt = view.findViewById(R.id.txt_FeedBack);

    }

    private void OnClicks() {

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

        contact_us_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_about_to_contactUs);

//                Dialog upload_box=new Dialog(getContext());
//                upload_box.setContentView(R.layout.contact_us_dialogue_box);
////                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                upload_box.setCanceledOnTouchOutside(false);
//                Window window=upload_box.getWindow();
//                window.setGravity(Gravity.CENTER);
//                upload_box.show();
//
//                upload_box.findViewById(R.id.done_btn).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        upload_box.dismiss();
//
//                    }
//                });

            }
        });

        feedback_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_about_to_feedback);

//                Dialog upload_box=new Dialog(getContext());
//                upload_box.setContentView(R.layout.feedback_dialogue_box);
////                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                upload_box.setCanceledOnTouchOutside(false);
//                Window window=upload_box.getWindow();
//                window.setGravity(Gravity.CENTER);
//                upload_box.show();
//
//                upload_box.findViewById(R.id.done_btn).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Toast.makeText(getContext(), "Thanks For Your Feedback", Toast.LENGTH_SHORT).show();
//
//                        upload_box.dismiss();
//
//                    }
//                });

            }
        });

    }
}