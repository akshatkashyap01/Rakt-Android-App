package com.example.rakt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rakt.DonorInformation.DonorInformation;
import com.example.rakt.DonorInformation.DonorRoot;
import com.google.gson.Gson;

import java.util.ArrayList;


public class RequestBloodScreen extends Fragment implements DonorRecycleView.callBack {

    View view;
    ImageView back;
    Button AskHelp_Button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_request_blood_screen, container, false);


        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FindIds();

        OnClicks();

        Gson gson = new Gson();

        RecyclerView recyclerView=view.findViewById(R.id.donor_holder);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SharedPreferences sharedPreferences= requireContext().getSharedPreferences(MainScreen.donor_file, Context.MODE_PRIVATE);
        String editData = sharedPreferences.getString(MainScreen.donor_key, "");

        if(editData.length()!=0)
        {

            DonorRoot donorRoot = gson.fromJson(editData, DonorRoot.class);

            DonorRecycleView donorRecycleView=new DonorRecycleView(donorRoot.getDonorInformation(),RequestBloodScreen.this);

            recyclerView.setAdapter(donorRecycleView);

        }
        else
        {

            Toast.makeText(getContext(),"no list found",Toast.LENGTH_SHORT).show();

        }





    }

    private void FindIds() {

        AskHelp_Button = view.findViewById(R.id.ask_for_help_btn);
        back = view.findViewById(R.id.image_back);

    }

    private void OnClicks() {


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

    }

    @Override
    public void callBack(DonorInformation donorInformation) {


        Bundle bundle=new Bundle();

        bundle.putSerializable("key",donorInformation);

        Navigation.findNavController(view).navigate(R.id.action_requestBloodScreen_to_donorScreen,bundle);

    }
}