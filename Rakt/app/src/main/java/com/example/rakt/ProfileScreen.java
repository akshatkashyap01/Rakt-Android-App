package com.example.rakt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class ProfileScreen extends Fragment {

    View view;
    ImageView back;
    EditText editText_name,editText_username,editText_password;
    String name,username,password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
//   Button Save_btn;

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("userfiles",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_profile_screen, container, false);

        FindIds();

        OnClicks();

        SetData();

        return view;
    }


    private void FindIds() {

        back = view.findViewById(R.id.image_back);
        editText_name = view.findViewById(R.id.edtx_name);
        editText_username = view.findViewById(R.id.edtx_user_name);
        editText_password = view.findViewById(R.id.edtx_password);
//        Save_btn = view.findViewById(R.id.save_btn);

    }

    private void OnClicks() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

//        Save_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                getActivity().onBackPressed();
//
//                Toast.makeText(getContext(), "Saved Successfully....", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

    private void SetData() {

        name = sharedPreferences.getString("name",null);
        username = sharedPreferences.getString("username",null);
        password = sharedPreferences.getString("password",null);

        editText_name.setText(name);
        editText_username.setText(username);
        editText_password.setText(password);

    }
}