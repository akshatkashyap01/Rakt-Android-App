package com.example.rakt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.SmileRating;
import com.hsalf.smileyrating.SmileyRating;
import com.hsalf.smileyrating.smileys.base.Smiley;


public class Feedback extends Fragment {

    View view;
    ImageView back_img;
    Button done_button;
    SmileyRating smileyRating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_feedback, container, false);

        FindIds();

        Onclicks();

        return view;
    }

    private void FindIds() {

        back_img = view.findViewById(R.id.feedback_image_back);
        done_button = view.findViewById(R.id.done_btn);
        smileyRating = view.findViewById(R.id.smile_rating);

    }

    private void Onclicks() {

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Thanks For Your Feedback", Toast.LENGTH_SHORT).show();

                getActivity().onBackPressed();

            }
        });

        smileyRating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {

                switch (type){

                    case BAD:

                        Toast.makeText(getContext(), "BAD", Toast.LENGTH_SHORT).show();
                        break;

                    case GOOD:

                        Toast.makeText(getContext(), "GOOD", Toast.LENGTH_SHORT).show();
                        break;

                    case GREAT:

                        Toast.makeText(getContext(), "GREAT", Toast.LENGTH_SHORT).show();
                        break;

                    case OKAY:

                        Toast.makeText(getContext(), "OKAY", Toast.LENGTH_SHORT).show();
                        break;

                    case TERRIBLE:

                        Toast.makeText(getContext(), "TERRIBLE", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });


    }

}