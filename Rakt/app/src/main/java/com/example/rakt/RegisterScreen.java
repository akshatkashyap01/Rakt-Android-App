package com.example.rakt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterScreen extends Fragment {

    View view;
    EditText editText_name,editText_user_name,editText_password;
    Button register;
    String name,password,username;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView login;

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences("userfiles",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_register_screen, container, false);



        FindIds();

        OnClicks();

        return view;
    }

    private void FindIds() {

        editText_name=view.findViewById(R.id.edtx_name);
        editText_user_name=view.findViewById(R.id.edtx_user_name);
        editText_password=view.findViewById(R.id.edtx_password);

        register=view.findViewById(R.id.btn_register);

        login=view.findViewById(R.id.txt_login);

    }

    private void OnClicks() {

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText_name.length()==0){

                    Toast.makeText(getContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();

                }else if(editText_user_name.length()==0){

                    Toast.makeText(getContext(), "Please Enter a Username for your account", Toast.LENGTH_SHORT).show();

                }else if(editText_password.length()==0){

                    Toast.makeText(getContext(), "Please Enter a Password for your account", Toast.LENGTH_SHORT).show();

                }else {

                    SecirityChacker();

                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_registerScreen_to_loginScreen);
            }
        });

    }

    private void SecirityChacker() {

        name = editText_user_name.getText().toString();
        password = editText_password.getText().toString();
        username = editText_user_name.getText().toString();

        editor.putString("name",name);
        editor.putString("password",password);
        editor.putString("username",username);
        editor.apply();

        Navigation.findNavController(view).navigate(R.id.action_registerScreen_to_loginScreen);

        Toast.makeText(getContext(), "Registered Successfully !", Toast.LENGTH_SHORT).show();

    }

}