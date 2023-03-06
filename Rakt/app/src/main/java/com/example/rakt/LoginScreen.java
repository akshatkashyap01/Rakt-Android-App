package com.example.rakt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginScreen extends Fragment {

   View view;
   Button login;
   String name,password;
   android.widget.EditText editText_user_name,editText_password;
   SharedPreferences sharedPreferences;
   SharedPreferences.Editor editor;
   TextView signin;


   @Override
   public void onAttach(Context context) {
       sharedPreferences = context.getSharedPreferences("userfiles",Context.MODE_PRIVATE);
       editor = sharedPreferences.edit();
       super.onAttach(context);
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_login_screen, container, false);

        FindId();

        onBackButtonPressed();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_loginScreen_to_registerScreen);
            }
        });

//        preferences = getContext().getSharedPreferences("checkbox",Context.MODE_PRIVATE);
//        String checkbox = preferences.getString("remember","");
//        if (checkbox.equals("true")){
//
//            Intent intent = new Intent(getActivity(),MainscreenActivity.class);
//            startActivity(intent);
//
//        }else if (checkbox.equals("false")){
//
//            Toast.makeText(getContext(), "Please Sign In", Toast.LENGTH_SHORT).show();
//        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (editText_user_name.length()==0 && editText_password.length()==0){

                    Toast.makeText(getContext(), "Please Enter Credentials", Toast.LENGTH_SHORT).show();

                }
//                else if (){
//
//                    Toast.makeText(getContext(), "Please Enter password", Toast.LENGTH_SHORT).show();
//
//                }
                else {

//                    Toast.makeText(getContext(), "Checking Done..!!", Toast.LENGTH_SHORT).show();

                    SecirityChacker();

                }
            }
        });

//        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                if(compoundButton.isChecked()){
//                    sharedPreferences = getContext().getSharedPreferences("checkbox",Context.MODE_PRIVATE);
//                    editor.putString("remember", "true");
//                    editor.apply();
//                    Toast.makeText(getContext(), "Checked", Toast.LENGTH_SHORT).show();
//                }else if (!compoundButton.isChecked()){
//                    sharedPreferences = getContext().getSharedPreferences("checkbox",Context.MODE_PRIVATE);
//                    editor.putString("remember", "false");
//                    editor.apply();
//                    Toast.makeText(getContext(), "Un-Checked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return  view;
    }

    private void SecirityChacker() {

        name = editText_user_name.getText().toString();
        password = editText_password.getText().toString();


        String uname,upass;
        uname = sharedPreferences.getString("name",null);
        upass = sharedPreferences.getString("password",null);

        if (name.equals(uname) && password.equals(upass)){

            Intent intent = new Intent(getActivity(),MainscreenActivity.class);
            startActivity(intent);

            editText_user_name.setText("");
            editText_password.setText("");

            Toast.makeText(getContext(), "Logged in !", Toast.LENGTH_SHORT).show();

        }else{

            editText_user_name.setText("");
            editText_password.setText("");

            Toast.makeText(getContext(), "Invalid Credentials !!", Toast.LENGTH_SHORT).show();
        }

    }


    private void FindId() {
        login=view.findViewById(R.id.login_btn);
        signin=view.findViewById(R.id.signin_txt);
        editText_user_name=view.findViewById(R.id.edtx_user_name);
        editText_password=view.findViewById(R.id.edtx_password);
//        remember=view.findViewById(R.id.checkbox_keep_logged_in);
    }

    private void onBackButtonPressed() {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (i == KeyEvent.KEYCODE_BACK) {
                        getActivity().finishAffinity();
                        return true;
                    }
                }
                return false;
            }
        });
    }
}