package com.example.rakt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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


public class SettingsSreenFragment extends Fragment {

    View view;
    ImageView back_img;
    TextView help_txt,logout_txt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_settings_sreen, container, false);

        FindIds();

        OnClicks();

        return view;
    }

    private void FindIds() {

        back_img = view.findViewById(R.id.image_back);
        help_txt = view.findViewById(R.id.txt_help);
        logout_txt = view.findViewById(R.id.txt_Logout);

    }

    private void OnClicks() {

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().onBackPressed();

            }
        });

        help_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_settingsSreenFragment_to_helpScreen);

            }
        });

        logout_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.exit)
                        .setTitle("Exit")
                        .setMessage("Are you sure want to exit the app")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent=new Intent(getContext(),StartingUiActivity.class);
                                startActivity(intent);

                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                }).show();


//                Dialog upload_box=new Dialog(getContext());
//                upload_box.setContentView(R.layout.confirm_exit_dialogue_box);
////                upload_box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                upload_box.setCanceledOnTouchOutside(false);
//                Window window=upload_box.getWindow();
//                window.setGravity(Gravity.CENTER);
//                upload_box.show();
//
//                upload_box.findViewById(R.id.exit_btn).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        upload_box.dismiss();
//
//                    }
//                });
//
//                upload_box.findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        upload_box.dismiss();
//
//                    }
//                });

            }
        });

    }
}